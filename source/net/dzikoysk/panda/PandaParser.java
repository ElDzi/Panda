package net.dzikoysk.panda;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.dzikoysk.panda.lang.LangElement;
import net.dzikoysk.panda.lang.Method;
import net.dzikoysk.panda.lang.Section;
import net.dzikoysk.panda.lang.util.SectionType;

public class PandaParser {
	
	private Stack<Section> parent = new Stack<>();
	private Stack<Character> section = new Stack<>();
	private Stack<SectionType> type = new Stack<>();
	
	private List<LangElement> elements = new ArrayList<>();
	
	private StringBuilder node = new StringBuilder();
	
	protected PandaParser(ScriptInfo si, String code){
		for(char c : code.toCharArray()){
			switch(c){
				case '{': { 
					this.startSection();
					break;
				} 
				case '}': {	
					this.createSection();
					break;
				}
				case ';': { 
					this.createMethod();
					break;
				}
				default: { 
					this.node.append(c);
					break;
				}
			}switch(node.toString()){
				case "event": {
					this.type.push(SectionType.EVENT_SECTION);
					break;
				}
				case "method": {
					this.type.push(SectionType.METHOD_SECTION);
					break;
				}
				case "if": {
					this.type.push(SectionType.CONDITIONS_SECTION);
					break;
				}
				case "else if": {
					this.type.push(SectionType.CONDITIONS_SECTION);
					break;
				}
				case "else": {
					this.type.push(SectionType.CONDITIONS_SECTION);
					break;
				}
			}
		}
	}
	
	private void createSection(){
		Section s = new Section();
		for(LangElement le : elements) s.addLangElement(le);
		if(!parent.empty()) parent.pop().setParent(s);
		elements.clear();
		parent.push(s);
		section.pop();
	}
	
	private void createMethod(){
		Method m = match(node.toString());
		if(m != null) elements.add(m);
		node = new StringBuilder();
	}
	
	private void startSection(){
		this.section.push('{');
	}
	
	private Method match(String recognize){
		for(SyntaxElement se : SyntaxElement.getElements()){
			Pattern p = Pattern.compile(se.getPattern());
			Matcher mp = p.matcher(recognize);
			if(mp.find()){
				Method m = new Method(se.getMethodClass());
				m.setVariables(null);
			}
		}
		return null;
	}
	
	
}

package net.dzikoysk.panda.lang;

import java.util.List;

import net.dzikoysk.panda.util.SectionMap;

public class Section extends LangElement {
	
	private Section parent;
	private List<LangElement> elements;
	private SectionMap<String, Object> variables;
	
	public Section(){
	}
	
	public void execute(){
		for(LangElement le : this.elements) le.execute();
	}
	
	public void setParent(Section s){
		this.parent = s;
	}
	
	public void addLangElement(LangElement element){
		this.elements.add(element);
	}
	
	public Section getParent(){
		return this.parent;
	}
	
	public List<LangElement> getLangElements(){
		return this.elements;
	}
	
	public Object getVariable(String var){
		return this.variables.get(var);
	}
	
	public SectionMap<String, Object> getVariables(){
		return this.variables;
	}

}

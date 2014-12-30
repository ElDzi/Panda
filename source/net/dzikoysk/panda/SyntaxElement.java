package net.dzikoysk.panda;

import java.util.ArrayList;
import java.util.List;

import net.dzikoysk.panda.lang.util.PandaMethod;

public class SyntaxElement {
	
	private static List<SyntaxElement> methods = new ArrayList<>();
	
	private final Class<? extends PandaMethod> clazz;
	private final String pattern;
	
	public SyntaxElement(Class<? extends PandaMethod> clazz, String pattern){
		this.clazz = clazz;
		this.pattern = pattern;
		methods.add(this);
	}
	
	public Class<? extends PandaMethod> getMethodClass(){
		return this.clazz;
	}
	
	public String getPattern(){
		return this.pattern;
	}
	
	public static List<SyntaxElement> getElements(){
		return methods;
	}

}

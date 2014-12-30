package net.dzikoysk.panda.lang;

import java.util.ArrayList;
import java.util.List;

public class Script extends Section {
	
	private final String name;
	private List<Section> sections;
	
	public Script(String s){
		this.name = s;
		sections = new ArrayList<>();
	}
	
	public void addSection(Section s){
		sections.add(s);
	}
	
	public String getName(){
		return this.name;
	}

}

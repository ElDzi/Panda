package net.dzikoysk.panda.util;

import java.util.HashMap;
import java.util.Map;

public class SectionMap<K, V> {
	
	private final SectionMap<String, Object> parent;
	private final Map<String, Object> local;
	
	public SectionMap(){
		this.local = new HashMap<String, Object>();
		this.parent = null;
	}
	
	public SectionMap(SectionMap<String, Object> parent){
		this.local = new HashMap<String, Object>();
		this.parent = parent;
	}
	
	public void put(String key, Object o){
		if(this.parent.parentContainsKey(key)) this.parent.put(key, o);
		else this.local.put(key, o);
	}
	
	public Object get(String name){
		Object o;
		o = local.get(name);
		if(o == null && parent != null) o = parent.get(name);
		return o;
	}
	
	public boolean containsKey(String name){
		if(local.containsKey(name)) return true;
		if(parent != null) if(parent.containsKey(name)) return true;
		return false;
	}
	
	public boolean parentContainsKey(String name){
		if(parent != null) if(parent.containsKey(name)) return true;
		return false;
	}
	
	public SectionMap<String, Object> getParent(){
		return this.parent;
	}
	
	public Map<String, Object> getLocal(){
		return this.local;
	}
}

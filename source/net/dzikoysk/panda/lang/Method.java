package net.dzikoysk.panda.lang;

import net.dzikoysk.panda.lang.util.PandaMethod;

public class Method extends LangElement {
	
	private final Class<? extends PandaMethod> clazz;
	private String[] variables;
	private Object res;
	
	public Method(Class<? extends PandaMethod> clazz){
		this.clazz = clazz;
	}

	public void setVariables(String[] vs){
		this.variables = vs;
	}

	@Override
	public void execute() {
		try {
			this.res = clazz.newInstance().execute(this.variables);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Object getResult(){
		return this.res;
	}
}

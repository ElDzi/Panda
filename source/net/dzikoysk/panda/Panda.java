package net.dzikoysk.panda;

import net.dzikoysk.panda.lang.util.PandaMethod;

public class Panda {
	
	public static void registerMethod(Class<? extends PandaMethod> clazz, String pattern){
		new SyntaxElement(clazz, pattern);
	}
	
}

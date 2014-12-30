package net.dzikoysk.panda;

public class PandaLoader {
		
	public static void load(ScriptInfo si, String code){
		new PandaParser(si, code);
	}
}

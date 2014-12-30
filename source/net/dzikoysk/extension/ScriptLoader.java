package net.dzikoysk.extension;

import java.io.File;

public class ScriptLoader {
	
	public static void loadSource(){
		File dir = new File("plugins");
		File[] files = dir.listFiles();
		for(File file : files){
			if(file.isDirectory()) continue;
		}
	}

}

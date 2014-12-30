package net.dzikoysk.extension;

import net.dzikoysk.extension.methods.Send;
import net.dzikoysk.panda.Panda;

public class BukkitExtension {
	
	public static void register(){
		Panda.registerMethod(Send.class, "{var}.send({var})");
	}

}

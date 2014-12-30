package net.dzikoysk.extension.methods;

import org.bukkit.entity.Player;

import net.dzikoysk.panda.lang.util.PandaMethod;

public class Send extends PandaMethod {

	@Override
	public Object execute(Object[] variables) {
		((Player) variables[0]).sendMessage((String) variables[1]);
		return null;
	}
}

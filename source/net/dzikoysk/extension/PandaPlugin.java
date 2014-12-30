package net.dzikoysk.extension;

import org.bukkit.plugin.java.JavaPlugin;

public class PandaPlugin extends JavaPlugin {
	
	private static PandaPlugin panda;
	
	@Override
	public void onLoad(){
		panda = this;
		BukkitExtension.register();
	}
	
	@Override
	public void onEnable(){
		ScriptLoader.loadSource();
	}
	
	@Override
	public void onDisable(){
		
	}

	public static PandaPlugin getInstance(){
		return panda;
	}
}

package org.maurijst.GradleTest.getPlayer;

import org.maurijst.GradleTest.getPlayer.ReadJson;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;


public final class main extends JavaPlugin {
	@Override
	public void onEnable() {
		// Plugin startup logic
		File pluginFolder = getDataFolder();
		ReadJson myJson = new ReadJson(pluginFolder);
		myJson.printAllUsernames();
	}

	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}
}

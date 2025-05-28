package org.maurijst.GradleTest.getPlayer;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadJson {

	private final File pluginFolder;
	private final Gson gson = new Gson();
	Logger log = Logger.getLogger("ReadJson");

	public ReadJson(final File pluginFolder) {
		this.pluginFolder = pluginFolder;
	}

	public List<PlayerData> loadAllPlayerData() {
		File file = new File(pluginFolder, "playerdata.json");

		if (!file.exists()) {
			log.warning("No player data found");
			return Collections.emptyList();
		}

		try (FileReader reader = new FileReader(file)) {
			Type listType = new TypeToken<List<PlayerData>>() {
			}.getType();
			return gson.fromJson(reader, listType);
		} catch (Exception e) {
			log.warning("Failed to load player data " + e.getMessage());
			return Collections.emptyList();
		}
	}

	public void printAllUsernames() {
		List<PlayerData> players = loadAllPlayerData();
		if (players == null) {
			log.warning("No players found");
			return;
		}

		for (PlayerData player : players) {
			if (log.isLoggable(Level.INFO)) {
				log.info(player.getUsername());
			}else{
				log.info("info is not loggable");
			}
		}
	}
}

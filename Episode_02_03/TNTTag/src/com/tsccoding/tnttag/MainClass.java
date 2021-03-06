package com.tsccoding.tnttag;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import com.tsccoding.tnttag.PlayerData.PlayerManager;

public class MainClass extends JavaPlugin {

	public HashMap<UUID,PlayerManager> playermanager = new HashMap<UUID,PlayerManager>();
	public GameMechanics gameMechanics;
	public GameManager gameManager;
	
	public void onEnable() {
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "\n\nTNT RUN has been Enabled\n\n");
		getServer().getPluginManager().registerEvents(new GameMechanics(), this);
		loadConfig();
		instanceClasses();
	}

	public void onDisable() {
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "\n\nTNT RUN has been Disabled\n\n");
	}

	public void loadConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	
	public void instanceClasses(){
		gameMechanics = new GameMechanics();
		gameManager = new GameManager();
	}

}

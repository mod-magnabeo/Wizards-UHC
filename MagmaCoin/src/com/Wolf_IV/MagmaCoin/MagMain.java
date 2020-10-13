package com.Wolf_IV.MagmaCoin;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.Wolf_IV.MagmaCoin.command.CStartCount;


public class MagMain extends JavaPlugin implements Listener{
	CStartCount cstartcount= new CStartCount();
	@Override
	public void onEnable() {
		getCommand("startcount").setExecutor(new CStartCount());
		getServer().getPluginManager().registerEvents(new MListeners(cstartcount), this);
	}
	
}

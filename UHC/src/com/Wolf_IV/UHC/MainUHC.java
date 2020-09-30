package com.Wolf_IV.UHC;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.Wolf_IV.UHC.Commands.CStart;
import com.Wolf_IV.UHC.Commands.CStartStop;
import com.Wolf_IV.UHC.TimerProt;


public class MainUHC extends JavaPlugin implements Listener{
	@Override
	public void onEnable() {
	getCommand("startuhc").setExecutor(new CStart(this));
	getCommand("startuhcstop").setExecutor(new CStartStop());
	getServer().getPluginManager().registerEvents(new UHCListener(), this);
	}
	@Override
	public void onDisable() {
	System.out.println("-Wolf_IV");
	}
	
	
}
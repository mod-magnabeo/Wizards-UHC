package com.Wolf_IV.All;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class Timer extends BukkitRunnable {

	int s = 0;
	@Override
	public void run() {
		s++;
		if(s == 120) {
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "daypass");
		}else if(s == 130) {
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "daypass");
		}else if(s == 140) {
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "daypass");
		}else if(s == 420) {
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "daypass");
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "time set 0");
			cancel();
		}

	}

}

package com.Wolf_IV.All.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Wolf_IV.All.MainA;
import com.Wolf_IV.All.Timer;

public class CMeetUp implements CommandExecutor {

	private static MainA main;
	public CMeetUp(MainA mainA) { 
		this.main= mainA;
		
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player)sender;
			if(cmd.getName().equalsIgnoreCase("meetup")) {
				player.sendMessage("§bMeetUp");
				for (Player playerO : Bukkit.getServer().getOnlinePlayers()) {
					playerO.getInventory().setContents(player.getInventory().getContents());
				}
				Timer tasks = new Timer();
				tasks.runTaskTimer(main, 0, 20);
			}
		}
		return false;
	}

}

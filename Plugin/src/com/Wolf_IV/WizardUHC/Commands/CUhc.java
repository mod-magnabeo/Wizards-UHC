package com.Wolf_IV.WizardUHC.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Wolf_IV.WizardUHC.MainW;

public class CUhc implements CommandExecutor {
private MainW main;
	public CUhc(MainW mainW) {
		this.main= mainW;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] arg3) {
		if(sender instanceof Player) {
			if(cmd.getName().equalsIgnoreCase("uhc")) {
			Player player = (Player)sender;
			player.sendMessage("§5§oVous avez été teleporter au hub du §5§l§oUHC");
			Location spawn =new Location(Bukkit.getWorld("worldSpawn"), 0.5, 81, 0.3);
			player.teleport(spawn);
			player.sendMessage(main.getConfig().getString("wizard.player.wizN"));
			return true;
			}
		}
		
		return false;
	}

}

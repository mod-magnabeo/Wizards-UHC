package com.Wolf_IV.WizardUHC.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CLoud implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player)sender;
			if(cmd.getName().equalsIgnoreCase("loud")) {
				
				if(args.length==0) {
					player.sendMessage("§4ERROR§b La commande est §a/loud <msg>");
				}
				if(args.length>=1) {
					StringBuilder bc = new StringBuilder();
					for(String part : args) {
						bc.append(part+ " ");
					}
					Bukkit.broadcastMessage("§6->§b§l§o"+player.getName()+"  §a§o"+bc.toString());
				}
			return true;
			}
			
			}
		return false;
	}

}

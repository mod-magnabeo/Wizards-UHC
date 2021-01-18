package com.Wolf_IV.WizardUHC.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CWoof implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
	if(sender instanceof Player) {
		if(cmd.getName().equalsIgnoreCase("woof")) {
		Player player = (Player)sender;
		player.sendMessage("§4§l-------->§d§k!§7§lBon T§2§lo§7§lut§2§lo§7§lu§d§k!§4§l<--------");
		return true;
		}
	}
		return false;
	}

}

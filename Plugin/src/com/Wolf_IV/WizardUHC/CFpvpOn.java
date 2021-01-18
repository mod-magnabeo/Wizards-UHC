package com.Wolf_IV.WizardUHC;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Wolf_IV.WizardUHC.Commands.CStart;

public class CFpvpOn implements CommandExecutor {
	private CStart p;
	public CFpvpOn(CStart p) {
		this.p=p;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] arg3) {
		if(sender instanceof Player) {
			if(cmd.getName().equalsIgnoreCase("fpvpon")) {
			Player player = (Player)sender;
			CStart.fpvp=true;
			Bukkit.broadcastMessage("§aLe freindly fire et le pvp est desactiver");
			p.Fteam.setAllowFriendlyFire(false);
			p.Pteam.setAllowFriendlyFire(false);
			p.Nteam.setAllowFriendlyFire(false);
			return true;
			}
		}
		return false;
	}

}

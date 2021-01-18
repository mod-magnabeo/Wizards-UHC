package com.Wolf_IV.WizardUHC;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Wolf_IV.WizardUHC.Commands.CStart;

public class CTeam implements CommandExecutor {

	
	private CStart p;
	public CTeam(CStart p) {
		this.p=p;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player)sender;
			if(cmd.getName().equalsIgnoreCase("t")) {
				
				if(args.length==0) {
					player.sendMessage("§4ERROR§b La commande est §a/t <msg>");
				}
				

				
				if(args.length>=1) {
					StringBuilder bc = new StringBuilder();
					for(String part : args) {
						bc.append(part+ " ");
					}
					if(player==p.wizF) {
						p.wizF.sendMessage("§c§lScorcier: §r§a"+bc.toString());
						p.Fser1.sendMessage("§c§lScorcier: §r§a"+bc.toString());
						p.Fser2.sendMessage("§c§lScorcier: §r§a"+bc.toString());
					}
					if(player==p.wizN) {
						p.wizN.sendMessage("§5§lScorcier: §r§a"+bc.toString());
						p.Nser1.sendMessage("§5§lScorcier: §r§a"+bc.toString());
						p.Nser2.sendMessage("§5§lScorcier: §r§a"+bc.toString());
					}
					if(player==p.wizP) {
						p.wizP.sendMessage("§8§lScorcier: §r§a"+bc.toString());
						p.Pser1.sendMessage("§8§lScorcier: §r§a"+bc.toString());
						p.Pser2.sendMessage("§8§lScorcier: §r§a"+bc.toString());
					}
					if(player==p.Fser1 || player==p.Fser2) {
						p.wizF.sendMessage("§c§lServiteur: §r§a"+bc.toString());
						p.Fser1.sendMessage("§c§lServiteur: §r§a"+bc.toString());
						p.Fser2.sendMessage("§c§lServiteur: §r§a"+bc.toString());
					}
					if(player==p.Pser1 || player==p.Pser2) {
						p.wizP.sendMessage("§5§lServiteur: §r§a"+bc.toString());
						p.Pser1.sendMessage("§5§lServiteur: §r§a"+bc.toString());
						p.Pser2.sendMessage("§5§lServiteur: §r§a"+bc.toString());
					}
					if(player==p.Nser1 || player==p.Nser2) {
						p.wizN.sendMessage("§8§lServiteur: §r§a"+bc.toString());
						p.Nser1.sendMessage("§8§lServiteur: §r§a"+bc.toString());
						p.Nser2.sendMessage("§8§lServiteur: §r§a"+bc.toString());
					}
					
				}
			return true;
			}
			
			}
		return false;
	}

}

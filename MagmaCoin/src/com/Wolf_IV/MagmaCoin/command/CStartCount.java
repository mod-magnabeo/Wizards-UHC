package com.Wolf_IV.MagmaCoin.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CStartCount implements CommandExecutor {
public int nubPlayer = 0;
public int coinMulti = 0;
public Player[] players = new Player[105];
public String[] playersName = new String[105];
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(sender instanceof Player) {
			if(cmd.getName().equalsIgnoreCase("startcount")) {
				
				for(int i =0; i <=100; i++) {
					players[i] = null;
					playersName[i] = null;
					
				}
				
				for (Player playerO : Bukkit.getServer().getOnlinePlayers()) {
					nubPlayer++;
					players[nubPlayer] = playerO;
					playersName[nubPlayer] = playerO.getName();
					}
				if(nubPlayer > 100) {
					Bukkit.broadcastMessage("§4La limite de joueur est a 100");
					return false;		
				}
				if(args[0] != null) {
					try {
						coinMulti = Integer.parseInt(args[0]);
					}catch(Exception e) {
						Bukkit.broadcastMessage("§4La command s'ercis /startcount [Le chiffre de la Multiplication de Magma(optionel)]");
						return false;
					}
				}else {
					coinMulti = 1;
				}
				
				
				
				
				
				return true;
			}
			}
		return false;
	}

}

package com.Wolf_IV.MagmaCoin.command;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Wolf_IV.MagmaCoin.writing.Read;
import com.Wolf_IV.MagmaCoin.writing.Write;

public class CEndCount implements CommandExecutor {
	
	private CStartCount p;
	public CEndCount(CStartCount p) {
	this.p = p;
	}

	@SuppressWarnings("static-access")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(sender instanceof Player) {
			if(cmd.getName().equalsIgnoreCase("endcount")) {
				if(p.ingame == false) {
					sender.sendMessage("§4Il n'y a pas de partie en cours");
					return false;
				}
				for(int i3 = 1; i3<=p.nubPlayer; i3++) {
      				 if(p.playerAlive[i3] == true) {
      					p.players[i3].sendMessage("§aVous avez gagner la partie, vous recever "+p.winP+" points");
      					p.playerP[i3]=p.playerP[i3] + p.winP;
      					p.playerS[i3]=p.playerS[i3] + p.winS;
      					
      				 }
      			 }
				Bukkit.broadcastMessage("§aLa partie est terminer");
				
				p.ingame=false;
				for(int i = 1; i<=p.nubPlayer; i++) {
					try {
						//Le code lit mal apprendre a lire bien
						Read.read(p.players[i].getUniqueId());
						p.playerP[i] = Read.point+p.playerP[i];
						p.playerS[i] = Math.round(Read.stats/(p.playerS[i]/100+1));
					} catch (Exception e) {
						
					}
					try {
						Write.write(p.players[i].getUniqueId(), p.playerP[i], p.playerS[i]);
					} catch (Exception e) {
						
					}
				}
				return true;
				}
			}
		return false;
	}

}

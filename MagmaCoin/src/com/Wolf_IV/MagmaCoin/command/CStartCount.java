package com.Wolf_IV.MagmaCoin.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CStartCount implements CommandExecutor {
public static int nubPlayer = 0;
public static int coinMulti = 0;
public static Player[] players = new Player[105];
public static String[] playersName = new String[105];
public static Player[] playerHit = new Player[105];
public static int[] playerP = new int[105];
public static int[] playerS = new int[105];
public static boolean[] playerAlive = new boolean[105];
public static boolean ingame;
//A config dans la config
public static int killP =3;
public static int surviveP =1;
public static int winP =7;
public static int participationP =4;
public static int killS =3;
public static int winS =7;
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(sender instanceof Player) {
			if(cmd.getName().equalsIgnoreCase("startcount")) {
				
				//A config dans la config
				killP =3;
				surviveP =1;
				winP =7;
				participationP =4;
				killS =3;
				winS=7;
				ingame =false;
				//A config dans la config
				
				
				for(int i =0; i <=100; i++) {
					players[i] = null;
					playersName[i] = null;
					playerHit[i] = null;
					playerP[i] = 0;
					playerS[i] = 0;
					playerAlive[i] = true;
					
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
				
				if(args.length != 0) {
					try {
						coinMulti = Integer.parseInt(args[0]);
						ingame =true;
						
					}catch(Exception e) {
						Bukkit.broadcastMessage("§4La command s'ercis /startcount [Le chiffre de la Multiplication de Magma(optionel)]");
						return false;
					}
				}else {
					
					coinMulti = 1;
					ingame =true;
					
				}
				
				
				
				
				killP = killP*coinMulti;
				surviveP = surviveP*coinMulti;
				winP = winP*coinMulti;
				participationP = participationP*coinMulti;
				ingame =true;
				 for(int i = 1; i<=nubPlayer; i++) {
					 playerP[i]=playerP[i]+participationP;
					 players[i].sendMessage("§aVous recevez "+participationP+" points de participation");
				 }
				 
				return true;
			}
			}
		return false;
	}

}

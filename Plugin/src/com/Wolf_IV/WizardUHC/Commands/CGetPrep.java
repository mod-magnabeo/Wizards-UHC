package com.Wolf_IV.WizardUHC.Commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CGetPrep implements CommandExecutor {
public static String nameFiniParcour= "Tu a fini le parcours bravo";
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player)sender;
			if(cmd.getName().equalsIgnoreCase("getprep")) {
				if(player.getName().equals("Wolf_IV")) {
					player.sendMessage("Si tu a oublier le mdp est horizonwolf");
				}
				if(args.length<=0) {
					Bukkit.broadcastMessage(player.getName()+" a esayer de se give les item prep mais il na pas mis le mdp");
				}else {
					if(args.length>1) {
					Bukkit.broadcastMessage(player.getName()+" a esayer de se give les item prep mais il a mis plusieurs mdp");
					}
				}
				if(args.length==1) {
					
						Bukkit.broadcastMessage(player.getName()+" C'est give des item prep");
						
						
					
				}
				
			return true;
			}
			
			}
		return false;
	}

}

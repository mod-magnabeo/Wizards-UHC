package com.Wolf_IV.WizardUHC.Commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;

public class CSpawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(sender instanceof Player) {
			if(cmd.getName().equalsIgnoreCase("spawn")) {
			Player player = (Player)sender;
			player.sendMessage("§5§oVous avez été teleporter au §5§l§oSpawn");
			Location spawn =new Location(Bukkit.getWorld("worldSpawn"), 30000, 80, 3000, -180, -34);
			player.teleport(spawn);
			player.setGameMode(GameMode.ADVENTURE);
			player.setHealth(20);
			player.setFoodLevel(20);
			for(PotionEffect effect : player.getActivePotionEffects())
			{
			    player.removePotionEffect(effect.getType());
			}
			
			
			//Stuff pour tp
			player.getInventory().clear();
			player.getInventory().setArmorContents(null);
			player.getInventory().setHeldItemSlot(8);
			ItemStack Leave = new ItemStack(Material.BARRIER);
			ItemMeta customL = Leave.getItemMeta();
			customL.setDisplayName("§c Quittez le serv");
			Leave.setItemMeta(customL);
			player.getInventory().setItemInHand(Leave);
			
			player.getInventory().setHeldItemSlot(0);
			ItemStack Kit = new ItemStack(Material.IRON_SWORD);
			ItemMeta customKit =Kit.getItemMeta();
			customKit.setDisplayName("§a MiniJeu");//fait gaffe de le changer aussi dans la method on Interact
			customKit.setLore(Arrays.asList("§cPour Faire des MiniJeux:", "§5-UHC Arena", "§e-KB Arena", "§4-Bow Spleef Arena"));
			Kit.setItemMeta(customKit);
			player.getInventory().setItemInHand(Kit);
			
			player.getInventory().setHeldItemSlot(4);
			ItemStack UHCTP = new ItemStack(Material.GOLDEN_APPLE);
			ItemMeta customUHC =UHCTP.getItemMeta();
			customUHC.setDisplayName("§4 Se tp au hub de Wizards UHC");//fait gaffe de le changer aussi dans la method on Interact
			customUHC.setLore(Arrays.asList("§cWizards UHC inspiré de Fate UHC", "§aPar:", "Wolf_IV"));
			UHCTP.setItemMeta(customUHC);
			player.getInventory().setItemInHand(UHCTP);
			//Stuff pour tp
			return true;
			}
		}
		
		return false;
	}

}

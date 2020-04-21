package com.Wolf_IV.WizardUHC.Role;

import java.util.Arrays;
import java.util.Iterator;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import com.Wolf_IV.WizardUHC.MainW;
import com.Wolf_IV.WizardUHC.Commands.CStart;


public class Wiz {
	private String nameLife="§dL'oeil de Tozhug";
	public static String nameGap="§dGolden Apple";
	private CStart p;
	private MainW main;
	public Wiz(CStart p, MainW main) {
	this.p =p;
	this.main= main;
	}
	
	
	public void interact(Player player, Action action, ItemStack it) {
		
		
		
		
		
		if(it.getType()== Material.SPIDER_EYE && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(nameLife)){
			if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
			if(player==p.wizN || player==p.wizF || player==p.wizP) {
			
				Player revive=null;
				if(player==p.wizF) {
				if(p.Fser1D==true) {
					revive=p.Fser1;
				}else if(p.Fser2D==true) {
					revive=p.Fser2;
				}else {
					player.sendMessage("§4Il n'y a personne a resucité");
				}
				}
				if(player==p.wizN) {
					if(p.Nser1D==true) {
						revive=p.Nser1;
					}else if(p.Nser2D==true) {
						revive=p.Nser2;
					}else {
						player.sendMessage("§4Il n'y a personne a resucité");
					}
					}
				
				if(player==p.wizP) {
					if(p.Pser1D==true) {
						revive=p.Pser1;
					}else if(p.Pser2D==true) {
						revive=p.Pser2;
					}else {
						player.sendMessage("§4Il n'y a personne a resucité");
					}
					}
				
				if(revive != null) {
				revive.teleport(player);
				revive.setGameMode(GameMode.SURVIVAL);
				revive.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
				revive.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
				revive.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
				revive.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
				revive.getInventory().setItemInHand(new ItemStack(Material.IRON_SWORD));
				revive.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 2));
				Bukkit.broadcastMessage(player.getName()+" a raise le joueur "+revive.getName());
				
				ItemStack item = player.getItemInHand();
				
				ItemStack Life = new ItemStack(Material.SPIDER_EYE);
				ItemMeta customLife =Life.getItemMeta();
				customLife.setDisplayName(nameLife);//fait gaffe de le changer aussi dans la method on Interact
				customLife.setLore(Arrays.asList("§cAvec un simple clic droit reanime un serviteur perdu"));
				customLife.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 1, true);
				customLife.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				Life.setItemMeta(customLife);
				
				player.getInventory().setItemInHand(Life);
				}
				
				
			}else {
				player.sendMessage("§4Il faut etre un scorcier pour ce servir de cette item");
			}
		}}
	
	
	
	
	}
	
	public void recipe() {
		ItemStack Life = new ItemStack(Material.SPIDER_EYE);
		ItemMeta customLife =Life.getItemMeta();
		customLife.setDisplayName(nameLife);//fait gaffe de le changer aussi dans la method on Interact
		customLife.setLore(Arrays.asList("§cAvec un simple clic droit reanime un serviteur perdu"));
		customLife.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 1, true);
		customLife.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		Life.setItemMeta(customLife);
		
		ShapedRecipe rLife=new ShapedRecipe(Life);
		rLife.shape("DDD","DSD","DDD");
		rLife.setIngredient('D', Material.DIAMOND);
		rLife.setIngredient('S', Material.SPIDER_EYE);
		main.getServer().addRecipe(rLife);
		
		ItemStack Gap = new ItemStack(Material.GOLDEN_APPLE);
		ItemMeta customGap =Gap.getItemMeta();
		customGap.setDisplayName(nameGap);
		customGap.setLore(Arrays.asList(nameGap));
		Gap.setItemMeta(customGap);
		
		ShapedRecipe rGapN=new ShapedRecipe(new ItemStack(Gap));
		rGapN.shape(" G ","GAG"," G ");
		rGapN.setIngredient('G', Material.GOLD_INGOT);
		rGapN.setIngredient('A', Material.APPLE);
		main.getServer().addRecipe(rGapN);
	}
}

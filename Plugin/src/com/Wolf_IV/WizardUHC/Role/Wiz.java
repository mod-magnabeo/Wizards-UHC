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
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.Wolf_IV.WizardUHC.MainW;
import com.Wolf_IV.WizardUHC.Commands.CStart;


public class Wiz {
	private String nameLife="�dL'oeil de Tozhug";
	public static String nameGap="�dGolden Apple";
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
					p.Fser1D=false;
				}else if(p.Fser2D==true) {
					revive=p.Fser2;
					p.Fser2D=false;
				}else {
					player.sendMessage("�4Il n'y a personne a resucit�");
				}
				}
				if(player==p.wizN) {
					if(p.Nser1D==true) {
						revive=p.Nser1;
						p.Nser1D=false;
					}else if(p.Nser2D==true) {
						revive=p.Nser2;
						p.Nser2D=false;
					}else {
						player.sendMessage("�4Il n'y a personne a resucit�");
					}
					}
				
				if(player==p.wizP) {
					if(p.Pser1D==true) {
						revive=p.Pser1;
						p.Pser1D=false;
					}else if(p.Pser2D==true) {
						revive=p.Pser2;
						p.Pser2D=false;
					}else {
						player.sendMessage("�4Il n'y a personne a resucit�");
					}
					}
				
				if(revive != null) {
					if(action == Action.RIGHT_CLICK_BLOCK) {
					
					
					
				revive.teleport(player);
				revive.setGameMode(GameMode.SURVIVAL);
				revive.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
				revive.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
				revive.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
				revive.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
				revive.getInventory().setItemInHand(new ItemStack(Material.IRON_SWORD));
				revive.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 2));
				Bukkit.broadcastMessage("�a"+player.getName()+"�b a raise le joueur �a"+revive.getName());
				ItemStack item = player.getItemInHand();
				
				ItemStack Life = new ItemStack(Material.SPIDER_EYE, item.getAmount()-1);
				ItemMeta customLife =Life.getItemMeta();
				customLife.setDisplayName(nameLife);
				customLife.setLore(Arrays.asList("�cAvec un simple clic droit reanime un serviteur perdu"));
				customLife.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 1, true);
				customLife.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				Life.setItemMeta(customLife);
				
				player.getInventory().setItemInHand(Life);
				
				
				
				p.Fser1.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100000, 0, true));
				p.Fser1.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 100000, 0, true));
				p.Nser1.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100000, 1, true));
				p.Nser1.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 100000, 1, true));
				p.Pser1.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 100000, 1, true));
				p.Fser2.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100000, 0, true));
				p.Fser2.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 100000, 0, true));
				p.Nser2.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100000, 1, true));
				p.Nser2.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 100000, 1, true));
				p.Pser2.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 100000, 1, true));
				
				if(revive==p.Pser1) {
					p.Pser1.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 20, 200, true));
				}
				if(revive==p.Pser2) {
					p.Pser2.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 20, 200, true));
				}
				if(player != p.wizN) {
					player.setHealth(player.getHealth()-4);
					p.wizN.setHealth(p.wizN.getHealth()+4);
					}
					
					}else {
						player.sendMessage("�4Cliquer sur le block ou vous le voulez que votre joueur soit raise");
					}
				}
				
				
			}else {
				player.sendMessage("�4Il faut etre un scorcier pour ce servir de cette item");
			}
		}}
	
	
	
	
	}
	
	public void recipe() {
		ItemStack Life = new ItemStack(Material.SPIDER_EYE);
		ItemMeta customLife =Life.getItemMeta();
		customLife.setDisplayName(nameLife);//fait gaffe de le changer aussi dans la method on Interact
		customLife.setLore(Arrays.asList("�cAvec un simple clic droit reanime un serviteur perdu"));
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
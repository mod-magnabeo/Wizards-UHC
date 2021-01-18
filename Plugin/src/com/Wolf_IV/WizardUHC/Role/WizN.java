package com.Wolf_IV.WizardUHC.Role;

import java.util.Arrays;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.Wolf_IV.WizardUHC.MainW;
import com.Wolf_IV.WizardUHC.Commands.CStart;
import com.Wolf_IV.WizardUHC.tasks.TimerNecro;
import com.Wolf_IV.WizardUHC.tasks.TimerTasks;

public class WizN {
	
	
	private CStart p;
	public static int teleportEnd=-1;
	private Random rand =new Random();
	private String nameNecro="Le Zombiefieur";
	public static String nameForce="§5Inspiration Nercromantique";
	private String nameSerCall="Pierre d'incatation pour Necromancié";
	private MainW main;
	public WizN(CStart p, MainW main) {
	this.p =p;
	this.main= main;
	}
	
	
	public void interact(Player player, Action action, ItemStack it) {
		if(it.getType()== Material.REDSTONE && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(nameNecro)) {
			if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
			if(player==p.wizN) {
				/*boolean choose;
				if(p.wizFN==true && p.Fser1D==true && p.Fser2D==true) {
					choose =rand.nextBoolean();
					if(choose==true) {
						p.NZom=p.Fser1;
					}else {
						p.NZom=p.Fser2;
					}
				}else if()
				if(p.wizPN==true && p.Pser1D==true && p.Pser2D==true) {
					choose =rand.nextBoolean();
					if(choose==true) {
						p.NZom=p.Pser1;
					}else {
						p.NZom=p.Pser2;
					}
				}
			if(p.NZom==null) {
				player.sendMessage("§4Il faut tué toute une équipe pour ce servir de cette item");
				return;
			}*/
				
				if(p.wizNZomI!=null) {
					p.NZom=Bukkit.getPlayer(p.wizNZomI);
					p.wizNZomI=null;
					
				}else {
					player.sendMessage("§4Il n'y a personne a infecter");
					return;
				}
			
			p.NZom.teleport(p.wizN);
			p.NZom.setGameMode(GameMode.SURVIVAL);
			p.NZom.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
			p.NZom.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET));
			p.NZom.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
			p.NZom.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
			p.NZom.getInventory().setItemInHand(new ItemStack(Material.IRON_SWORD));
			p.NZom.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 1));
			p.NZom.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100000, 0));
			p.NZom.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 100000, 0));
			p.wizN.getInventory().setItemInHand(null);
			Bukkit.broadcastMessage("§aLes Necromacié on zombifié un joueur");
			
			}else {
				player.sendMessage("§4Tu nes pas Necromancié");
			}
			
			}
		}
		
		
		
		/**
		 * TP END
		 */
		if( it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(nameSerCall)) {
			if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
			if(player==p.wizN) {
				p.wizN.setItemInHand(null);
				
				TimerNecro tasks = new TimerNecro(p);
				tasks.runTaskTimer(main, 0, 20);
				this.teleportEnd=11;
				
			}
		}
	
		}
	
	
	
		
		/**
	 * END
	 */
	}
	
	public void recipe() {
		ItemStack Necro = new ItemStack(Material.REDSTONE);
		ItemMeta customNecro =Necro.getItemMeta();
		customNecro.setDisplayName(nameNecro);//fait gaffe de le changer aussi dans la method on Interact
		customNecro.setLore(Arrays.asList("§cAvec un simple clic droit", "zombifie un de tes enemis mort","si il n'a aucun alliés vivant"));
		customNecro.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 1, true);
		customNecro.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		Necro.setItemMeta(customNecro);
		
		ShapedRecipe rNecro=new ShapedRecipe(Necro);
		rNecro.shape("RRR","RDR","RRR");
		rNecro.setIngredient('R', Material.ROTTEN_FLESH);
		rNecro.setIngredient('D', Material.DIAMOND_BLOCK);
		main.getServer().addRecipe(rNecro);
		
		ItemStack SerCall = new ItemStack(405);
		ItemMeta customSerCall =SerCall.getItemMeta();
		customSerCall.setDisplayName(nameSerCall);//fait gaffe de le changer aussi dans la method on Interact
		customSerCall.setLore(Arrays.asList("§cAvec un simple clic droit", "tp toi a l'end, tue l'ender","dragon et ton equipe est au complet"));
		customSerCall.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 1, true);
		customSerCall.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		SerCall.setItemMeta(customSerCall);
		
		ShapedRecipe rSerCall=new ShapedRecipe(SerCall);
		rSerCall.shape("DDD","DLD","DDD");
		rSerCall.setIngredient('L', Material.LAPIS_BLOCK);
		rSerCall.setIngredient('D', Material.DIAMOND);
		main.getServer().addRecipe(rSerCall);
		
		ItemStack Force = new ItemStack(Material.ROTTEN_FLESH);
		ItemMeta customForce =Force.getItemMeta();
		customForce.setDisplayName(nameForce);//fait gaffe de le changer aussi dans la method on Interact
		customForce.setLore(Arrays.asList("§cEn mangant cette Item", "Augementer vos dégat","pendant 10s"));
		customForce.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 1, true);
		customForce.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		Force.setItemMeta(customForce);
		
		ShapedRecipe rForce=new ShapedRecipe(Force);
		rForce.shape("GGG","GHG","GGG");
		rForce.setIngredient('H', Material.NETHER_STAR);
		rForce.setIngredient('G', Material.GOLD_INGOT);
		main.getServer().addRecipe(rForce);
		
	}

}

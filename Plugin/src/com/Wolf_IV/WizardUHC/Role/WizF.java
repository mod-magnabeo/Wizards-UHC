package com.Wolf_IV.WizardUHC.Role;

import java.util.Arrays;
import java.util.HashMap;

import javax.persistence.Entity;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.LargeFireball;
import org.bukkit.entity.Player;
import org.bukkit.entity.WitherSkull;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

import com.Wolf_IV.WizardUHC.MainW;
import com.Wolf_IV.WizardUHC.Commands.CStart;
import com.Wolf_IV.WizardUHC.tasks.LittleThings;
import com.Wolf_IV.WizardUHC.tasks.TimerProt;
import com.Wolf_IV.WizardUHC.tasks.TimerTasks;

public class WizF {
	 public HashMap<String, Long> cooldowns = new HashMap<String, Long>();
	 private boolean cool=true;
	private String nameFireBall="§cBoule de feu";
	private String nameSerCall="Pierre d'incatation pour Scorcier de Feu";
	private String nameCaFeu="§cBouclier de Lave";
	public static String nameDiamondE="§aDiament Enflamé";
	public static String l1Wither="§9Cliquer sur ce";
	public static String l4Sortie="§9votre stuff";
	private CStart p;
	private MainW main;
	public WizF(CStart p, MainW main) {
	this.p =p;
	this.main=main;
	}

	public void interact(Player player, Action action, ItemStack it) {
		if(it.getType()== Material.FIREBALL && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(nameFireBall)){
            if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
            if(player==p.wizF) {
              
                
                player.launchProjectile(LargeFireball.class).setVelocity(player.getLocation().getDirection().multiply(0.5));
                
                ItemStack item = player.getItemInHand();
                
                ItemStack FireBall = new ItemStack(Material.FIREBALL, item.getAmount()-1);
                ItemMeta customFireBall =FireBall.getItemMeta();
                customFireBall.setDisplayName(nameFireBall);//fait gaffe de le changer aussi dans la method on Interact
                customFireBall.setLore(Arrays.asList("§2Avec un simple clic droit lance une boule de feu explosive"));
                customFireBall.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 1, true);
                customFireBall.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                FireBall.setItemMeta(customFireBall);
                player.getInventory().setItemInHand(FireBall);
              
               
            }else {
                player.sendMessage("§4Il faut etre Scorcier de Feu pour ce servir de cette item");
            }
            }
        }

		
			if(it.getType()== Material.BLAZE_POWDER && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(nameSerCall)){
	            if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
	            if(player==p.wizF) {
	            	Location netherPrep =new Location(Bukkit.getWorld("worldSpawn_nether"), 20000, 80, 200000);
	            	p.wizF.setHealth(20.0);
	  		      p.Fser1.setHealth(20.0);
	  		      p.Fser2.setHealth(20.0);
	  		      p.wizF.teleport(netherPrep);
	  		      p.Fser1.teleport(netherPrep);
	  		      p.Fser2.teleport(netherPrep);
	  		      p.wizF.setGameMode(GameMode.ADVENTURE);
	  		      p.Fser1.setGameMode(GameMode.ADVENTURE);
	  		      p.Fser2.setGameMode(GameMode.ADVENTURE);
	  		    Location Block =new Location(Bukkit.getWorld("worldSpawn_nether"), 20028, 81, 200000);
		  		  Block.getBlock().setType(Material.AIR);
		  		  Block =new Location(Bukkit.getWorld("worldSpawn_nether"), 19998, 81, 200000);
		  		  Block.getBlock().setType(Material.DIAMOND_BLOCK);
		  		  p.wizF.getInventory().setItemInHand(null);
	  		     

	            	
	  		      
	  		      
	            	}
	            }
	            }
		
			
		
		
			if(it.getType()== Material.LAVA_BUCKET && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(nameCaFeu)){
	            if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
	            if(player==p.wizF) { 
	            	LittleThings.setBlock(p.wizF, Material.STATIONARY_LAVA, 0, 0, 0);
	            	LittleThings.setBlock(p.wizF, Material.STATIONARY_LAVA, -1, 0, 0);
	            	LittleThings.setBlock(p.wizF, Material.STATIONARY_LAVA, -1, 0, -1);
	            	LittleThings.setBlock(p.wizF, Material.STATIONARY_LAVA, 0, 0, -1);
	            	LittleThings.setBlock(p.wizF, Material.STATIONARY_LAVA, 1, 0, 0);
	            	LittleThings.setBlock(p.wizF, Material.STATIONARY_LAVA, 0, 0, 1);
	            	LittleThings.setBlock(p.wizF, Material.STATIONARY_LAVA, 1, 0, -1);
	            	LittleThings.setBlock(p.wizF, Material.STATIONARY_LAVA, -1, 0, 1);
	            	LittleThings.setBlock(p.wizF, Material.STATIONARY_LAVA, 1, 0, 1);
	            	p.wizF.getInventory().setItemInHand(null);
	                 
	            	
	            	
	            	
	            }else {
	                player.sendMessage("§4Il faut etre Scorcier de Feu pour ce servir de cette item");
	            } 
	            }
	            }
	}
	
	public void recipe() {
		
		
		ItemStack FireBall = new ItemStack(Material.FIREBALL, 5);
		ItemMeta customFireBall =FireBall.getItemMeta();
		customFireBall.setDisplayName(nameFireBall);//fait gaffe de le changer aussi dans la method on Interact
		customFireBall.setLore(Arrays.asList("§2Avec un simple clic droit lance une boule de feu explosive"));
		customFireBall.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 1, true);
        customFireBall.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		
		FireBall.setItemMeta(customFireBall);
		
		ShapedRecipe rFr=new ShapedRecipe(FireBall);
		rFr.shape("NCN","CBC","NCN");
		rFr.setIngredient('C', Material.COAL);
		rFr.setIngredient('B', Material.BLAZE_POWDER);
		rFr.setIngredient('N', Material.FLINT_AND_STEEL);
		main.getServer().addRecipe(rFr);
		
		
		ItemStack SerCall = new ItemStack(Material.BLAZE_POWDER);
		ItemMeta customSerCall =SerCall.getItemMeta();
		customSerCall.setDisplayName(nameSerCall);//fait gaffe de le changer aussi dans la method on Interact
		customSerCall.setLore(Arrays.asList("§cPeut etre utilisé dans le craft de la", "pierre d'incatation du scorcier de Feu"));
		customSerCall.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 1, true);
		customSerCall.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		SerCall.setItemMeta(customSerCall);
		
		ShapedRecipe rSerCall=new ShapedRecipe(SerCall);
		rSerCall.shape("DOD","ODO","DOD");
		rSerCall.setIngredient('O', Material.OBSIDIAN);
		rSerCall.setIngredient('D', Material.DIAMOND);
		main.getServer().addRecipe(rSerCall);
		
		ItemStack CaFeu = new ItemStack(Material.LAVA_BUCKET);
		ItemMeta customCaFeu =CaFeu.getItemMeta();
		customCaFeu.setDisplayName(nameCaFeu);//fait gaffe de le changer aussi dans la method on Interact
		customCaFeu.setLore(Arrays.asList("§2Avec un simple clic droit former", "une protection de lave autour de vous"));
		customCaFeu.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 1, true);
        customCaFeu.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		
		CaFeu.setItemMeta(customCaFeu);
		
		ShapedRecipe rCF=new ShapedRecipe(CaFeu);
		rCF.shape("SOS","DLD","SFS");
		rCF.setIngredient('D', Material.DIAMOND);
		rCF.setIngredient('L', Material.LAVA_BUCKET);
		rCF.setIngredient('S', Material.SOUL_SAND);
		rCF.setIngredient('F', Material.IRON_BLOCK);
		rCF.setIngredient('O', Material.GHAST_TEAR);
		main.getServer().addRecipe(rCF);
		
	}
	
	
	public void signClick(BlockState signB, Player player, Action action) {
		  if( action == Action.RIGHT_CLICK_BLOCK) {
			  if(signB instanceof Sign) {
				  Sign sign= (Sign)signB;
				  if(sign.getLine(0).equalsIgnoreCase(l1Wither)) {
					    p.wizF.setGameMode(GameMode.SURVIVAL);
			  		      p.Fser1.setGameMode(GameMode.SURVIVAL);
			  		      p.Fser2.setGameMode(GameMode.SURVIVAL);
			  		      p.wizF.getInventory().clear();
			  		      p.Fser1.getInventory().clear();
			  		      p.Fser2.getInventory().clear();
			  		    Location WitherFight =new Location(Bukkit.getWorld("worldSpawn_nether"), 20500, 80, 200000);
			  		    p.wizF.teleport(WitherFight);
			  		    p.Fser1.teleport(WitherFight);
			  		    p.Fser2.teleport(WitherFight);
			  		  Location Block =new Location(Bukkit.getWorld("worldSpawn_nether"), 20028, 81, 200000);
			  		  Block.getBlock().setType(Material.DIAMOND_BLOCK);
			  		  Block =new Location(Bukkit.getWorld("worldSpawn_nether"), 19998, 81, 200000);
			  		  Block.getBlock().setType(Material.AIR);
				  }
			  }
	}
		  
		  if( action == Action.RIGHT_CLICK_BLOCK) {
			  if(signB instanceof Sign) {
				  Sign sign= (Sign)signB;
				  if(sign.getLine(3).equalsIgnoreCase(l4Sortie)) {
					    p.wizF.setGameMode(GameMode.SURVIVAL);
			  		      p.Fser1.setGameMode(GameMode.SURVIVAL);
			  		      p.Fser2.setGameMode(GameMode.SURVIVAL);
			  		    Location nether0 =new Location(Bukkit.getWorld("worldSpawn_nether"), 0, 60, 0);
			  		    p.wizF.teleport(nether0);
			  		    p.Fser1.teleport(nether0);
			  		    p.Fser2.teleport(nether0);
			  		  TimerProt tasks = new TimerProt();
		                tasks.runTaskTimer(main, 0, 20);
		                TimerProt.timerFallF=15;

				  }
			  }
	}
		  
	}
}

package com.Wolf_IV.WizardUHC.Role;

import java.util.Arrays;
import java.util.HashSet;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.Wolf_IV.WizardUHC.MainW;
import com.Wolf_IV.WizardUHC.Commands.CGetPrep;
import com.Wolf_IV.WizardUHC.Commands.CStart;
import com.Wolf_IV.WizardUHC.tasks.LittleThings;
import com.Wolf_IV.WizardUHC.tasks.TimerNecro;
import com.Wolf_IV.WizardUHC.tasks.TimerProt;

import net.minecraft.server.v1_8_R1.ShapedRecipes;

public class WizP {
	public static boolean enfermeFrappe;
	public static boolean jumpGod=false;
	public static int teleportMount=-1;
	private String nameSerCall="Pierre d'incatation pour Scorcier de pierre";
	private String nameResist="§2Pierre de Densification";
	private String nameFiniJ="§2Bravo tu a fini le jump";
	public static  String nameEferme="§2Pierre includo";
	private CStart p;
	private MainW main;
	public WizP(CStart p, MainW main) {
	this.p =p;
	this.main=main;
	}
	
	public void interact(Player player, Action action, ItemStack it) {
		
		
		
		int i;
		if(it.getType()== Material.IRON_BLOCK && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(nameResist)){
			if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
			if(player==p.wizP) {
				p.wizP.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 200, 0, true));
				p.Pser1.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 200, 0, true));
				p.Pser2.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 200, 0, true));
				
			    ItemStack item = player.getItemInHand();
			    
				ItemStack PEle = new ItemStack(Material.IRON_BLOCK, item.getAmount()-1);
				ItemMeta customEle =PEle.getItemMeta();
				customEle.setDisplayName(nameResist);//fait gaffe de le changer aussi dans la method on Interact
				customEle.setLore(Arrays.asList("§cAvec un simple clic droit donne un effet", "de Resistance I 10s a toute ton equipe"));
				customEle.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 1, true);
				customEle.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				PEle.setItemMeta(customEle);
				p.wizP.getInventory().setItemInHand(PEle);
			    
				
			}else {
				player.sendMessage("§4Il faut etre Scorcier de Pierre pour ce servir de cette item");
			}
		}}
		
		
		
		
		if(it.getType()== Material.CLAY_BALL && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(nameSerCall)){
			if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
			if(player==p.wizP) {
				
				
				Location ploc = player.getLocation();
				Location bloc =new Location(player.getWorld(), ploc.getX(), ploc.getY()-1,ploc.getZ());
				Block block =bloc.getBlock();
				player.sendMessage(Math.floor(ploc.getX())+" "+Math.floor(ploc.getY()));
				if(block.getType()==Material.DIAMOND_BLOCK && Math.floor(ploc.getX())==1500.0 && Math.floor(ploc.getZ())==1500.0) {
					p.wizP.setItemInHand(null);
					Location mount = new Location(player.getWorld(), 20000, 150, -20000);
					p.wizP.teleport(mount);
					p.Pser1.teleport(mount);
					p.wizP.setGameMode(GameMode.ADVENTURE);
					p.Pser1.setGameMode(GameMode.ADVENTURE);
					jumpGod=true;
				}else {
					player.sendMessage("Tu n'est pas sur un block de diament ou en 1500 1500");
				}
			}
			}
		}
		
		if(it.getType()== Material.STONE && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(nameFiniJ)){
			if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
			if(player==p.wizP || player==p.Pser1) {
				Location sortie = new Location(player.getWorld(), 1500, 255, 1500);
				player.setItemInHand(null);
				p.wizP.teleport(sortie);
				p.Pser1.teleport(sortie);
				p.Pser2.teleport(sortie);
				 TimerProt tasks = new TimerProt();
	                tasks.runTaskTimer(main, 0, 20);
	                TimerProt.timerFallP=30;
	                p.wizP.setGameMode(GameMode.SURVIVAL);
					p.Pser1.setGameMode(GameMode.SURVIVAL);
					p.Pser1.setGameMode(GameMode.SURVIVAL);
					jumpGod=false;
					p.wizP.setHealth(28.0);
					p.Pser1.setHealth(28.0);
					p.Pser2.setHealth(28.0);
				
				}
			}
		
		}
		
		
	
	
	}
	
	public void recipe() {
		ItemStack PEle = new ItemStack(Material.IRON_BLOCK);
		ItemMeta customEle =PEle.getItemMeta();
		customEle.setDisplayName(nameResist);//fait gaffe de le changer aussi dans la method on Interact
		customEle.setLore(Arrays.asList("§cAvec un simple clic droit donne un effet", "de Resistance I 10s a toute ton equipe"));
		customEle.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 1, true);
		customEle.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		PEle.setItemMeta(customEle);
		
		ShapedRecipe rEle=new ShapedRecipe(PEle);
		rEle.shape(" I ","ICI"," I ");
		rEle.setIngredient('C', Material.PUMPKIN);
		rEle.setIngredient('I', Material.IRON_BLOCK);
		main.getServer().addRecipe(rEle);
		
		ItemStack PEferme = new ItemStack(Material.COBBLESTONE);
		ItemMeta customEferme =PEferme.getItemMeta();
		customEferme.setDisplayName(nameEferme);//fait gaffe de le changer aussi dans la method on Interact
		customEferme.setLore(Arrays.asList("§cAvec un simple clic gauche ","§cEnferme ta cible dans un bloc de piere"));
		customEferme.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 1, true);
		customEferme.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		PEferme.setItemMeta(customEferme);
		
		ShapedRecipe rEferme=new ShapedRecipe(PEferme);
		rEferme.shape("SSS","SGS","SSS");
		rEferme.setIngredient('S', Material.STONE);
		rEferme.setIngredient('G', Material.GOLD_BLOCK);
		main.getServer().addRecipe(rEferme);
		
		ItemStack SerCall = new ItemStack(Material.CLAY_BALL);
		ItemMeta customSerCall =SerCall.getItemMeta();
		customSerCall.setDisplayName(nameSerCall);//fait gaffe de le changer aussi dans la method on Interact
		customSerCall.setLore(Arrays.asList("§cAvec un simple clic droit En etant sur un", " block de diams en 1500 1500 tp toi a la", " montagne fait le jump et ton equipe est au complet"));
		customSerCall.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 1, true);
		customSerCall.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		SerCall.setItemMeta(customSerCall);
		
		ShapedRecipe rSerCall=new ShapedRecipe(SerCall);
		rSerCall.shape("GDG","DSD","GDG");
		rSerCall.setIngredient('S', Material.STONE);
		rSerCall.setIngredient('D', Material.DIAMOND);
		rSerCall.setIngredient('G', Material.GOLD_INGOT);
		main.getServer().addRecipe(rSerCall);
		
		ItemStack FiniJ = new ItemStack(Material.STONE);
		ItemMeta customFiniJ =FiniJ.getItemMeta();
		customFiniJ.setDisplayName(nameFiniJ);//fait gaffe de le changer aussi dans la method on Interact
		customFiniJ.setLore(Arrays.asList("§cAvec un simple clic droit tp toi", "en 1500 1500 et ton equipe est unifier"));
		customFiniJ.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 1, true);
		customFiniJ.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		FiniJ.setItemMeta(customFiniJ);
		
		ShapedRecipe rFiniJ=new ShapedRecipe(FiniJ);
		rFiniJ.shape("BBB","BSB","BBB");
		rFiniJ.setIngredient('S', Material.STONE);
		rFiniJ.setIngredient('B', Material.BEDROCK);
		main.getServer().addRecipe(rFiniJ);
	}
	public void enferage(Entity enfermé) {
		
		LittleThings.setBlock(enfermé, Material.COBBLESTONE, 0, -1, 0);
		LittleThings.setBlock(enfermé, Material.COBBLESTONE, 0, 2, 0);
		LittleThings.setBlock(enfermé, Material.COBBLESTONE, 1, 0, 0);
		LittleThings.setBlock(enfermé, Material.COBBLESTONE, 1, 1, 0);
		LittleThings.setBlock(enfermé, Material.COBBLESTONE, -1, 0, 0);
		LittleThings.setBlock(enfermé, Material.COBBLESTONE, -1, 1, 0);
		LittleThings.setBlock(enfermé, Material.COBBLESTONE, 0, 0, 1);
		LittleThings.setBlock(enfermé, Material.COBBLESTONE, 0, 1, 1);
		LittleThings.setBlock(enfermé, Material.COBBLESTONE, 0, 0, -1);
		LittleThings.setBlock(enfermé, Material.COBBLESTONE, 0, 1, -1);
		Location ploc = enfermé.getLocation();
		Location tel =new Location(enfermé.getWorld(),  Math.floor(ploc.getX())+0.5, Math.floor(ploc.getY()), Math.floor(ploc.getZ())+0.5);
		enfermé.teleport(tel);
		
		ItemStack item = p.wizP.getItemInHand();
		
		ItemStack PEferme = new ItemStack(Material.COBBLESTONE, item.getAmount()-1);
		ItemMeta customEferme =PEferme.getItemMeta();
		customEferme.setDisplayName(nameEferme);//fait gaffe de le changer aussi dans la method on Interact
		customEferme.setLore(Arrays.asList("§cAvec un simple clic gauche ","§cEnferme ta cible dans un bloc de piere"));
		customEferme.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 1, true);
		customEferme.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		PEferme.setItemMeta(customEferme);
		if(item.getAmount()==1) {
			p.wizP.getInventory().setItemInHand(null);
		}else
		{p.wizP.getInventory().setItemInHand(PEferme);}
		
		p.wizP.sendMessage("§2 Joueur enfermé");
		
		
		
	}
	
	
}
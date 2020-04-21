package com.Wolf_IV.WizardUHC.Role;

import java.util.Arrays;
import java.util.HashSet;

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

import com.Wolf_IV.WizardUHC.MainW;
import com.Wolf_IV.WizardUHC.Commands.CStart;
import com.Wolf_IV.WizardUHC.tasks.LittleThings;
import com.Wolf_IV.WizardUHC.tasks.TimerNecro;

import net.minecraft.server.v1_8_R1.ShapedRecipes;

public class WizP {
	public static boolean enfermeFrappe;
	public static boolean jumpOn=false;
	public static int teleportMount=-1;
	private String nameSerCall="Pierre d'incatation pour Scorcier de pierre";
	private String nameElevate="§2Pierre d'élévation";
	public static  String nameEferme="§2Pierre includo";
	private CStart p;
	private MainW main;
	public WizP(CStart p, MainW main) {
	this.p =p;
	this.main=main;
	}
	
	public void interact(Player player, Action action, ItemStack it) {
		
		
		
		int i;
		if(it.getType()== Material.MOSSY_COBBLESTONE && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(nameElevate)){
			if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
			if(player==p.wizP) {
				Location ploc=p.wizP.getLocation();
				if(ploc.getY()+100<256) {
					for(i=0;i<100;i++) {
						Location block =new Location(p.wizP.getWorld(),ploc.getX(),ploc.getY()+i,ploc.getZ());
						block.getBlock().setType(Material.COBBLESTONE);
					}
					Location upLoc =new Location(p.wizP.getWorld(),ploc.getX(),ploc.getY()+102,ploc.getZ());
				p.wizP.teleport(upLoc);
				
			    ItemStack item = player.getItemInHand();
			    
				ItemStack PEle = new ItemStack(Material.MOSSY_COBBLESTONE, item.getAmount()-1);
				ItemMeta customEle =PEle.getItemMeta();
				customEle.setDisplayName(nameElevate);//fait gaffe de le changer aussi dans la method on Interact
				customEle.setLore(Arrays.asList("§cAvec un simple clic droit Eleve toi dans le ciel"));
				customEle.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 1, true);
				customEle.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				PEle.setItemMeta(customEle);
				p.wizP.getInventory().setItemInHand(PEle);
			    
				}else {
					player.sendMessage("§4Vous etes trop haut pour vous servir de cette item 155 bloc d'hauteur limite");
				}
			}else {
				player.sendMessage("§4Il faut etre Scorcier de Pierre pour ce servir de cette item");
			}
		}}
		
		
	
		if(it.getType()== Material.CLAY_BALL && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(nameSerCall)) {
			if(action == Action.RIGHT_CLICK_BLOCK) {
			if(player==p.wizP) {
				HashSet<Byte> nulll = new HashSet<Byte>();
				
				Block block = player.getTargetBlock(nulll, 5);
				if(block.getType()==Material.DIAMOND_BLOCK) {
				p.wizP.setItemInHand(null);
				Location mount = new Location(player.getWorld(), 20000, 80, -20000);
				p.wizP.teleport(mount);
				p.Pser1.teleport(mount);
				
				}
				
				
			}
		}
	
		}
		
		
	
	
	}
	
	public void recipe() {
		ItemStack PEle = new ItemStack(Material.MOSSY_COBBLESTONE);
		ItemMeta customEle =PEle.getItemMeta();
		customEle.setDisplayName(nameElevate);//fait gaffe de le changer aussi dans la method on Interact
		customEle.setLore(Arrays.asList("§cAvec un simple clic droit Eleve toi dans le ciel"));
		customEle.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 1, true);
		customEle.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		PEle.setItemMeta(customEle);
		
		ShapedRecipe rEle=new ShapedRecipe(PEle);
		rEle.shape("CCC","CLC","CCC");
		rEle.setIngredient('C', Material.MOSSY_COBBLESTONE);
		rEle.setIngredient('L', Material.LAPIS_BLOCK);
		main.getServer().addRecipe(rEle);
		
		ItemStack PEferme = new ItemStack(Material.MOSSY_COBBLESTONE);
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
		customSerCall.setLore(Arrays.asList("§cAvec un simple clic droit sur un bloc de", " diams en 1500 1500 tp toi a la", " montagne fait le jump et ton equipe est au complet"));
		customSerCall.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 1, true);
		customSerCall.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		SerCall.setItemMeta(customSerCall);
		
		ShapedRecipe rSerCall=new ShapedRecipe(SerCall);
		rSerCall.shape("GDG","DSD","GDG");
		rSerCall.setIngredient('S', Material.STONE);
		rSerCall.setIngredient('D', Material.DIAMOND);
		rSerCall.setIngredient('D', Material.GOLD_BLOCK);
		main.getServer().addRecipe(rSerCall);
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
		
		ItemStack PEferme = new ItemStack(Material.MOSSY_COBBLESTONE, item.getAmount()-1);
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

package com.Wolf_IV.WizardUHC.Role;

import java.util.Arrays;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.LargeFireball;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.Wolf_IV.WizardUHC.MainW;
import com.Wolf_IV.WizardUHC.Commands.CStart;
import com.Wolf_IV.WizardUHC.tasks.TimerFly;
import com.Wolf_IV.WizardUHC.tasks.TimerNecro;
import com.Wolf_IV.WizardUHC.tasks.TimerProt;

public class WizE {

	private String nameBallon="§9WaterBallon";
	private String nameFly="§9Plume d'élévation";
	private CStart p;
	private MainW main;
	public WizE(CStart p, MainW main) {
		this.p =p;
		this.main=main;
		}
		
		public void interact(Player player, Action action, ItemStack it) {
			if(it.getType()== Material.ICE && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(nameBallon)){
				if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
				if(player==p.wizE) {
					
					player.launchProjectile(Snowball.class).setVelocity(player.getLocation().getDirection().multiply(0.5));
	                
	                ItemStack item = player.getItemInHand();
	                
	                ItemStack Ballon = new ItemStack(Material.ICE, item.getAmount()-1);
	    			ItemMeta customBallon =Ballon.getItemMeta();
	    			customBallon.setDisplayName(nameBallon);//fait gaffe de le changer aussi dans la method on Interact
	    			customBallon.setLore(Arrays.asList("§cAvec un simple clic droit ", "lancez un WaterBaloon"));
	    			customBallon.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 1, true);
	    			customBallon.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	    			Ballon.setItemMeta(customBallon);
	                player.getInventory().setItemInHand(Ballon);
	                
					}
				}
			
			}
			if(it.getType()== Material.FEATHER && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(nameFly)){
				if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
				if(player==p.wizE) {
					if(TimerFly.enCours==false) {
					p.wizE.sendMessage("§eVous pouvez désormais voler");
	                p.wizE.setAllowFlight(true);
	                p.wizE.setFlying(true);
	                p.wizE.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 100, 255, true));
	                TimerFly tasks = new TimerFly(p);
					tasks.runTaskTimer(main, 0, 20);
					TimerFly.timer=5;
					 ItemStack item = player.getItemInHand();
					ItemStack Fly = new ItemStack(Material.FEATHER, item.getAmount()-1);
					ItemMeta customFly =Fly.getItemMeta();
					customFly.setDisplayName(nameFly);//fait gaffe de le changer aussi dans la method on Interact
					customFly.setLore(Arrays.asList("§cAvec un simple clic droit ", "voler pendant 5s"));
					customFly.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 1, true);
					customFly.addItemFlags(ItemFlag.HIDE_ENCHANTS);
					Fly.setItemMeta(customFly);
					player.getInventory().setItemInHand(Fly);
					}else {
						p.wizE.sendMessage("§cVous voler déjà");
					}
	                
					}
				}
			
			}
		}
		
		public void recipe() {
			ItemStack Ballon = new ItemStack(Material.ICE);
			ItemMeta customBallon =Ballon.getItemMeta();
			customBallon.setDisplayName(nameBallon);//fait gaffe de le changer aussi dans la method on Interact
			customBallon.setLore(Arrays.asList("§cAvec un simple clic droit ", "lancez un WaterBaloon"));
			customBallon.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 1, true);
			customBallon.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			Ballon.setItemMeta(customBallon);
			
			ShapedRecipe rBallon=new ShapedRecipe(Ballon);
			rBallon.shape("VLV","OEF","VHV");
			rBallon.setIngredient('V', Material.THIN_GLASS);
			rBallon.setIngredient('L', Material.LAPIS_BLOCK);
			rBallon.setIngredient('O', Material.REDSTONE_BLOCK);
			rBallon.setIngredient('E', Material.WATER_BUCKET);
			rBallon.setIngredient('F', Material.IRON_BLOCK);
			rBallon.setIngredient('H', Material.COAL_BLOCK);
			main.getServer().addRecipe(rBallon);
			
			ItemStack Fly = new ItemStack(Material.FEATHER);
			ItemMeta customFly =Fly.getItemMeta();
			customFly.setDisplayName(nameFly);//fait gaffe de le changer aussi dans la method on Interact
			customFly.setLore(Arrays.asList("§cAvec un simple clic droit ", "voler pendant 5s"));
			customFly.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 1, true);
			customFly.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			Fly.setItemMeta(customFly);
			
			ShapedRecipe rFly=new ShapedRecipe(Fly);
			rFly.shape("FPF","DBD","FGF");
			rFly.setIngredient('F', Material.FEATHER);
			rFly.setIngredient('P', Material.RABBIT_HIDE);
			rFly.setIngredient('G', Material.LAPIS_BLOCK);
			rFly.setIngredient('D', Material.DIAMOND);
			rFly.setIngredient('B', Material.GLASS_BOTTLE);
			main.getServer().addRecipe(rFly);
		}
}

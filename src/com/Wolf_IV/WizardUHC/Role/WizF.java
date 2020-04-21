package com.Wolf_IV.WizardUHC.Role;

import java.util.Arrays;
import java.util.HashMap;

import javax.persistence.Entity;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
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

import com.Wolf_IV.WizardUHC.MainW;
import com.Wolf_IV.WizardUHC.Commands.CStart;
import com.Wolf_IV.WizardUHC.tasks.TimerTasks;

public class WizF {
	 public HashMap<String, Long> cooldowns = new HashMap<String, Long>();
	 private boolean cool=true;
	private String nameFireBall="§cBoule de feu";
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
		
	}
}

package com.Wolf_IV.All;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class AListener implements Listener {
	
	public Location locReCentre(Location loc) {
		return new Location(loc.getWorld(),loc.getX()+0.5F, loc.getY()+0.5F,loc.getZ()+0.5F);
	}
	@EventHandler
	   public void onBlockBreak(BlockBreakEvent event) {
	       Material block = event.getBlock().getType();
	       if (block == Material.IRON_ORE) {
	            event.getBlock().setType(Material.AIR);
	           event.setCancelled(true);
	          event.getBlock().getDrops().clear();
	 
	          event.getPlayer().getWorld().dropItemNaturally(locReCentre(event.getBlock().getLocation()), new ItemStack(Material.IRON_INGOT));
	          event.getPlayer().giveExp(1);
	 
	        return;
	      }
	       if (block == Material.GOLD_ORE) {
	            event.getBlock().setType(Material.AIR);
	           event.setCancelled(true);
	          event.getBlock().getDrops().clear();
	 
	          event.getPlayer().getWorld().dropItemNaturally(locReCentre(event.getBlock().getLocation()), new ItemStack(Material.GOLD_INGOT));
	          event.getPlayer().giveExp(1);
	        return;
	      }
	       if (block == Material.LEAVES || block == Material.LEAVES_2) {
	    	   Random rand = new Random();
	    	   int r= rand.nextInt(30)+1;
	    	   if(r==1) {
	           event.getPlayer().getWorld().dropItemNaturally(locReCentre(event.getBlock().getLocation()), new ItemStack(Material.APPLE));
	    	   }
	        return;
	      }
	  }
	
	@EventHandler
	   public void onPlayerMove(PlayerMoveEvent event) {
		if(event.getPlayer() == Bukkit.getPlayer("d78eaf316b004a38b5c884f9068da0d8")/*Karma*/ || 
				event.getPlayer() == Bukkit.getPlayer("d60fa8019daa45ffaea53c30acd93cb8") /*Sharky080*/|| 
				event.getPlayer() == Bukkit.getPlayer("5ca542b8891446a0ae21c9c71f33bdc9")/*DiplodusPedibus*/) {
			if(event.getPlayer().getLocation().getY() < 13.0 && event.getPlayer().getLocation().getY() > 9.0) {
				event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 100, 0, true));
			}
			
		}
	}
}

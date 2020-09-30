package com.Wolf_IV.All;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import com.Wolf_IV.All.AListener;


public class MainA extends JavaPlugin implements Listener{
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new AListener(), this);
	}
	
	
	
	@Override
	public void onDisable() {
	System.out.println("-Wolf_IV");
	}
	@EventHandler
	   public void onBlockBreak(BlockBreakEvent event) {
	       Material block = event.getBlock().getType();
	       if (block == Material.IRON_ORE) {
	            event.getBlock().setType(Material.AIR);
	           event.setCancelled(true);
	          event.getBlock().getDrops().clear();
	 
	          event.getPlayer().getInventory().addItem(new ItemStack(Material.IRON_INGOT));
	          event.getPlayer().giveExp(1);
	 
	        return;
	      }
	       if (block == Material.GOLD_ORE) {
	            event.getBlock().setType(Material.AIR);
	           event.setCancelled(true);
	          event.getBlock().getDrops().clear();
	 
	          event.getPlayer().getInventory().addItem(new ItemStack(Material.GOLD_INGOT));
	          event.getPlayer().giveExp(1);
	        return;
	      }
	       if (block == Material.LEAVES || block == Material.LEAVES_2) {
	    	   Random rand = new Random();
	    	   int r= rand.nextInt(30)+1;
	    	   if(r==1) {
	           event.getPlayer().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.APPLE));
	    	   }
	        return;
	      }
	  }
}

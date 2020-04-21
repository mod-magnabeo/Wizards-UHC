package com.Wolf_IV.WizardUHC;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.Wolf_IV.WizardUHC.Commands.CStart;
import com.Wolf_IV.WizardUHC.Role.Wiz;
import com.Wolf_IV.WizardUHC.Role.WizF;
import com.Wolf_IV.WizardUHC.Role.WizN;
import com.Wolf_IV.WizardUHC.Role.WizP;
import com.Wolf_IV.WizardUHC.tasks.TimerTasks;


public class WListeners implements Listener {
	private MainW main;
	private CStart p;
	public WListeners(MainW mainW, CStart p) {
	this.main =mainW;
	this.p = p;
	}
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player =event.getPlayer();
		//Spawn
		Location spawn =new Location(Bukkit.getWorld("worldSpawn"), 0, 81, 0, -180, -34);
		player.teleport(spawn);
		player.setGameMode(GameMode.ADVENTURE);
		player.setHealth(20);
		player.setFoodLevel(20);
		for(PotionEffect effect : player.getActivePotionEffects())
		{
		    player.removePotionEffect(effect.getType());
		}
		
		
		//Stuff pour tp
		player.getInventory().clear();
		player.getInventory().setArmorContents(null);
		player.getInventory().setHeldItemSlot(8);
		ItemStack Leave = new ItemStack(Material.BARRIER);
		ItemMeta customL = Leave.getItemMeta();
		customL.setDisplayName("�c Quittez le serv");//fait gaffe de le changer aussi dans la method on Interact
		Leave.setItemMeta(customL);
		player.getInventory().setItemInHand(Leave);
		
		player.getInventory().setHeldItemSlot(0);
		ItemStack Kit = new ItemStack(Material.IRON_SWORD);
		ItemMeta customKit =Kit.getItemMeta();
		customKit.setDisplayName("�a MiniJeu");//fait gaffe de le changer aussi dans la method on Interact
		customKit.setLore(Arrays.asList("�cPour Faire des MiniJeux:", "�5-UHC Arena", "�e-KB Arena", "�4-Bow Spleef Arena"));
		Kit.setItemMeta(customKit);
		player.getInventory().setItemInHand(Kit);
		
		player.getInventory().setHeldItemSlot(4);
		ItemStack UHCTP = new ItemStack(Material.GOLDEN_APPLE);
		ItemMeta customUHC =UHCTP.getItemMeta();
		customUHC.setDisplayName("�4 Se tp au hub de Wizards UHC");//fait gaffe de le changer aussi dans la method on Interact
		customUHC.setLore(Arrays.asList("�cWizards UHC inspir� de Fate UHC", "�aPar:", "Wolf_IV"));
		UHCTP.setItemMeta(customUHC);
		player.getInventory().setItemInHand(UHCTP);
		
		
		//Stuff pour tp
		//Spawn
	}
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		Player player =event.getPlayer();
		Action action =event.getAction();
		ItemStack it =event.getItem();
		if(it == null) return;
		WizN wizN = new WizN(p, main);
		WizP wizP = new WizP(p, main);
		WizF wizF = new WizF(p, main);
		Wiz wiz = new Wiz(p, main);
		
		wizN.interact(player, action, it);
		wizP.interact(player, action, it);
		wizF.interact(player, action, it);
		wiz.interact(player, action, it);
		
		if(it.getType()== Material.GOLDEN_APPLE && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("�4 Se tp au hub de Wizards UHC")) {
			player.sendMessage("�5�oVous avez �t� teleporter au hub du �5�l�oUHC");
				Location spawn =new Location(Bukkit.getWorld("worldSpawn"), 0.5, 81, 0.3);
				player.teleport(spawn);
			
			
		
		}
		if(it.getType()== Material.BARRIER && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("�c Quittez le serv")) {
			player.kickPlayer("�eVous avez quittez Wizards UHC");
		}
		
		if(it.getType()== Material.IRON_SWORD && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("�a MiniJeu")) {
			Inventory inv = Bukkit.createInventory(null, 27, "�8M�ai�8n�ai�8Jeu");
			player.openInventory(inv);
			
			ItemStack UHCA = new ItemStack(Material.DIAMOND_SWORD);
			ItemMeta customUA = UHCA.getItemMeta();
			customUA.setDisplayName("�5 UHC Arena");
			customUA.setLore(Arrays.asList("�4-Diamond Sword", "�4-Gapple", "�4-Diamond Stuff", "�4-Lava Bucket", "�4-WaterBucket"));
			UHCA.setItemMeta(customUA);
			
			
			ItemStack KBA = new ItemStack(Material.STICK);
			ItemMeta customKBA = KBA.getItemMeta();
			customKBA.setDisplayName("�e KB Arena");
			customKBA.addEnchant(Enchantment.KNOCKBACK, 4, true);
			customKBA.setLore(Arrays.asList("�4-Stick Knockback V"));
			KBA.setItemMeta(customKBA);
			
			ItemStack Spleef = new ItemStack(Material.TNT);
			ItemMeta customS = Spleef.getItemMeta();
			customS.setDisplayName("�4 Bow Spleef Arena");
			customS.setLore(Arrays.asList("�4-Bow an Arrow Flame"));
			Spleef.setItemMeta(customS);
			
			
			inv.setItem(11, UHCA);
			inv.setItem(13, KBA);
			inv.setItem(15, Spleef);
		}
	
	
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent event) {
		Inventory inv = event.getInventory();
		Player player =(Player) event.getWhoClicked();
		ItemStack current= event.getCurrentItem();
		if(inv.getName().equalsIgnoreCase("�8M�ai�8n�ai�8Jeu")) {
		if(current==null) return;
		
		event.setCancelled(true);
		
		if(current.getType()==Material.DIAMOND_SWORD) Kit.UhcArena(player); 
		if(current.getType()==Material.STICK) Kit.KbArena(player);
		if(current.getType()==Material.TNT) Kit.BSpleefArena(player);
		}
	}
	
	@EventHandler
	  public void onEntityDeath(EntityDeathEvent event) {
		if ((event.getEntity() instanceof EnderDragon)) {
		      Location sortieN =new Location(Bukkit.getWorld("worldSpawn"), 500, 80, 500);
		      p.wizN.teleport(sortieN);
		      p.Nser1.teleport(sortieN);
		      p.Nser2.teleport(sortieN);
		    }
	    if (!(event.getEntity() instanceof Player)) {
	      return;
	    }
	 Player victim = (Player)event.getEntity();
	 if(WizP.jumpOn==true && victim==p.Pser1 || victim==p.wizP) {
		 return;
	 }
	 
	 victim.setGameMode(GameMode.SPECTATOR);
	 if(victim==p.Nser1) {
		 p.Nser1D=true;
	 }else  if(victim==p.Nser2) {
		 p.Nser2D=true;
	 }else  if(victim==p.Fser1) {
		 p.Fser1D=true;
	 }else  if(victim==p.Fser2) {
		 p.Fser2D=true;
	 }else  if(victim==p.Pser1) {
		 p.Pser1D=true;
	 }else  if(victim==p.Pser2) {
		 p.Pser2D=true;
	 }
	    //Player killed
	 	EntityDamageEvent e = event.getEntity().getLastDamageCause();
	    if (!(e instanceof EntityDamageByEntityEvent)) {
	      return;
	    }
	    EntityDamageByEntityEvent nEvent = (EntityDamageByEntityEvent)e;
	 
	    if (!(nEvent.getDamager() instanceof Player)) {
	      return;
	    }
	    //Player killed
	    Player killer = (Player)nEvent.getDamager();
	    
	    if(killer==p.wizN || killer==p.Nser1 || killer==p.Nser2) {
	    	if(victim==p.wizF) {
	    		p.wizFN=true;
	    		p.wizPN=false;
	    	}
	    	if(victim==p.wizP) {
	    		p.wizFN=false;
	    		p.wizPN=true;
	    	}
	    }
	    
	}
	
	@EventHandler
    public void onTestEntityDamage(EntityDamageByEntityEvent event) {
        
		 Entity enferm� = (Entity)event.getEntity();
    	 Entity  enfermeur= (Entity)event.getDamager();
    	 ItemStack it =p.wizP.getItemInHand();
 		if(it == null) return;
    	 if(it.getType()== Material.MOSSY_COBBLESTONE && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(WizP.nameEferme)){
    		 
    	 
		if(enfermeur==p.wizP) {
			WizP wizP = new WizP(p, main);
			wizP.enferage(enferm�);
			event.setCancelled(true);
		}
    	 }
		
		
		
		
		
		
		if(TimerTasks.Ingame==true) {
			if (event.getDamager() instanceof Player){
            if (event.getEntity() instanceof Player) {
            	 Player victim = (Player)event.getEntity();
            	 Player Damager = (Player)event.getDamager();
               
            	 if(TimerTasks.pvp==true) {
            		 if(victim==p.Nser1||victim==p.Nser2||victim==p.wizN) {
            			 if(Damager==p.Nser1||Damager==p.Nser2||Damager==p.wizN) {
            				 event.setCancelled(true);
            				 Damager.sendMessage("Ne frappe pas t'es alli�s");
            			 }
            		 }
            		 
            		 if(victim==p.Fser1||victim==p.Fser2||victim==p.wizF) {
            			 if(Damager==p.Fser1||Damager==p.Fser2||Damager==p.wizF) {
            				 event.setCancelled(true);
            				 Damager.sendMessage("Ne frappe pas t'es alli�s");
            			 }
            		 }
            		 
            		 if(victim==p.Fser1||victim==p.Fser2||victim==p.wizF) {
            			 if(Damager==p.Fser1||Damager==p.Fser2||Damager==p.wizF) {
            				 event.setCancelled(true);
            				 Damager.sendMessage("Ne frappe pas t'es alli�s");
            			 }
            		 }
            		 
            	 }else {
            		 //PVP Off
            		 event.setCancelled(true);
            	 }
            	 
            }
         }
       
        }
	}

	
	@EventHandler
	public void onPlayerEat(PlayerItemConsumeEvent event) {
		Player player =event.getPlayer();
		ItemStack it =event.getItem();
		if(it == null) return;
		if(it.getType()== Material.GOLDEN_APPLE) {
			if(it.hasItemMeta() && it.getItemMeta().hasLore()) {
				return;
			}
		player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 120*20, 1));
		}
			
		
	}
	
	
}
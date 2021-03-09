package com.Wolf_IV.WizardUHC;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Cow;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.entity.Wither;
import org.bukkit.event.Cancellable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent; 
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.material.Sign;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import com.Wolf_IV.WizardUHC.Commands.CStart;
import com.Wolf_IV.WizardUHC.Role.Temple;
import com.Wolf_IV.WizardUHC.Role.Wiz;
import com.Wolf_IV.WizardUHC.Role.WizE;
import com.Wolf_IV.WizardUHC.Role.WizF;
import com.Wolf_IV.WizardUHC.Role.WizN;
import com.Wolf_IV.WizardUHC.Role.WizP;
import com.Wolf_IV.WizardUHC.tasks.LittleThings;
import com.Wolf_IV.WizardUHC.tasks.TimerProt;
import com.Wolf_IV.WizardUHC.tasks.TimerTasks;


public class WListeners implements Listener {
	public Scoreboard s;	
	private MainW main;
	private CStart p;
	public WListeners(MainW mainW, CStart p) {
	this.main =mainW;
	this.p = p;
	}
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player =event.getPlayer();
		if(MainW.ingame==true) {
			if(player.getName().equalsIgnoreCase(p.wizFNa)) {
				p.wizF=player;
			}
			if(player.getName().equalsIgnoreCase(p.wizPNa)) {
				p.wizP=player;
			}
			if(player.getName().equalsIgnoreCase(p.wizNNa)) {
				p.wizN=player;
			}
			if(player.getName().equalsIgnoreCase(p.wizENa)) {
				p.wizE=player;
			}
			if(player.getName().equalsIgnoreCase(p.Nser1Na)) {
				p.Nser1=player;
			}
			if(player.getName().equalsIgnoreCase(p.Nser2Na)) {
				p.Nser2=player;
			}
			if(player.getName().equalsIgnoreCase(p.Pser1Na)) {
				p.Pser1=player;
			}
			if(player.getName().equalsIgnoreCase(p.Pser2Na)) {
				p.Pser2=player;
			}
			if(player.getName().equalsIgnoreCase(p.Fser1Na)) {
				p.Fser1=player;
			}
			if(player.getName().equalsIgnoreCase(p.Fser2Na)) {
				p.Fser2=player;
			}
			if(player.getName().equalsIgnoreCase(p.Eser1Na)) {
				p.Eser1=player;
			}
			if(player.getName().equalsIgnoreCase(p.Eser2Na)) {
				p.Eser2=player;
			}
			return;
		}
		//Spawn
		Location spawn =new Location(Bukkit.getWorld("worldSpawn"), 30000, 80, 3000, -180, -34);
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
		customL.setDisplayName("§c Quittez le serv");//fait gaffe de le changer aussi dans la method on Interact
		Leave.setItemMeta(customL);
		player.getInventory().setItemInHand(Leave);
		
		player.getInventory().setHeldItemSlot(0);
		ItemStack Kit = new ItemStack(Material.IRON_SWORD);
		ItemMeta customKit =Kit.getItemMeta();
		customKit.setDisplayName("§a MiniJeu");//fait gaffe de le changer aussi dans la method on Interact
		customKit.setLore(Arrays.asList("§cPour Faire des MiniJeux:", "§5-UHC Arena", "§e-KB Arena", "§4-Bow Spleef Arena"));
		Kit.setItemMeta(customKit);
		player.getInventory().setItemInHand(Kit);
		
		player.getInventory().setHeldItemSlot(4);
		ItemStack UHCTP = new ItemStack(Material.GOLDEN_APPLE);
		ItemMeta customUHC =UHCTP.getItemMeta();
		customUHC.setDisplayName("§4 Se tp au hub de Wizards UHC");//fait gaffe de le changer aussi dans la method on Interact
		customUHC.setLore(Arrays.asList("§cWizards UHC inspiré de Fate UHC", "§aPar:", "Wolf_IV"));
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
		
		if(event.getClickedBlock() != null && action == Action.RIGHT_CLICK_BLOCK) {
			if(event.getClickedBlock().getType()==Material.ENDER_PORTAL_FRAME) {
				Temple t =new Temple(p, main);
				t.incant(player, event.getClickedBlock().getLocation());
			}
		}
		
		
		WizN wizN = new WizN(p, main);
		WizP wizP = new WizP(p, main);
		WizF wizF = new WizF(p, main);
		WizE wizE = new WizE(p, main);
		Wiz wiz = new Wiz(p, main);
		
		
		if(it != null) {
		
		
		wizN.interact(player, action, it);
		wizP.interact(player, action, it);
		wizF.interact(player, action, it);
		wizE.interact(player, action, it);
		wiz.interact(player, action, it);
		
		if(it.getType()== Material.GOLDEN_APPLE && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("§4 Se tp au hub de Wizards UHC")) {
			player.sendMessage("§5§oVous avez été teleporté au hub du §5§l§oUHC");
				Location spawn =new Location(Bukkit.getWorld("worldSpawn"), 0.5, 81, 0.3);
				player.teleport(spawn);
				
			
			
		
		}
		if(it.getType()== Material.BARRIER && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("§c Quittez le serv")) {
			player.kickPlayer("§eVous avez quitté Wizards UHC");
		}
		
		if(it.getType()== Material.MILK_BUCKET ) {
			 if(TimerTasks.Ingame==true) {
			player.getInventory().setItemInHand(null);
			player.sendMessage("§4Les seaux de lait sont interdits");
			Bukkit.broadcastMessage(player.getName()+" A essayé de boire un seau de lait");
			 }
			
		}
		
		if(it.getType()== Material.SNOW_BALL ) {
			 if(TimerTasks.Ingame==true) {
			player.getInventory().setItemInHand(null);
			player.sendMessage("§4Les snowball sont interdit");
			Bukkit.broadcastMessage(player.getName()+" A lancer une snowball");
			 }
			
		}
		if(it.getType()== Material.BREWING_STAND_ITEM ) {
			player.sendMessage("§4Les popo sont désactivé");
			player.getInventory().setItemInHand(null);
			Bukkit.broadcastMessage(player.getName()+" s'est construit un alembique");
		}
		
		if(it.getType()== Material.IRON_SWORD && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("§a MiniJeu")) {
			Inventory inv = Bukkit.createInventory(null, 27, "§8M§ai§8n§ai§8Jeu");
			player.openInventory(inv);
			
			ItemStack UHCA = new ItemStack(Material.DIAMOND_SWORD);
			ItemMeta customUA = UHCA.getItemMeta();
			customUA.setDisplayName("§5 UHC Arena");
			customUA.setLore(Arrays.asList("§4-Diamond Sword", "§4-Gapple", "§4-Diamond Stuff", "§4-Lava Bucket", "§4-WaterBucket"));
			UHCA.setItemMeta(customUA);
			
			
			ItemStack KBA = new ItemStack(Material.STICK);
			ItemMeta customKBA = KBA.getItemMeta();
			customKBA.setDisplayName("§e KB Arena");
			customKBA.addEnchant(Enchantment.KNOCKBACK, 4, true);
			customKBA.setLore(Arrays.asList("§4-Stick Knockback V"));
			KBA.setItemMeta(customKBA);
			
			ItemStack Spleef = new ItemStack(Material.TNT);
			ItemMeta customS = Spleef.getItemMeta();
			customS.setDisplayName("§4 Bow Spleef Arena");
			customS.setLore(Arrays.asList("§4-Bow an Arrow Flame"));
			Spleef.setItemMeta(customS);
			
			
			inv.setItem(11, UHCA);
			inv.setItem(13, KBA);
			inv.setItem(15, Spleef);
			
		}
	
		}
		BlockState block= event.getClickedBlock().getState();
		if(block != null) {
			wizF.signClick(block, player, action);
			}
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent event) {
		Inventory inv = event.getInventory();
		Player player =(Player) event.getWhoClicked();
		ItemStack current= event.getCurrentItem();
		if(inv.getName().equalsIgnoreCase("§8M§ai§8n§ai§8Jeu")) {
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
		      Location sortieN =new Location(Bukkit.getWorld("worldSpawn"), 500, 255, 500);
		      p.wizN.setHealth(20.0);
		      p.Nser1.setHealth(20.0);
		      p.Nser2.setHealth(20.0);
		      p.wizN.teleport(sortieN);
		      p.Nser1.teleport(sortieN);
		      p.Nser2.teleport(sortieN);
		      TimerProt tasks = new TimerProt();
              tasks.runTaskTimer(main, 0, 20);
              TimerProt.timerFallN=30;
		       }
		
		if ((event.getEntity() instanceof Wither)) {
			  Location WitherFight =new Location(Bukkit.getWorld("worldSpawn_nether"), 20000, 80, 200000);
			  p.wizF.setHealth(20.0);
		      p.Fser1.setHealth(20.0);
		      p.Fser2.setHealth(20.0);
		      p.wizF.teleport(WitherFight);
		      p.Fser1.teleport(WitherFight);
		      p.Fser2.teleport(WitherFight);
		      p.wizF.setGameMode(GameMode.ADVENTURE);
  		      p.Fser1.setGameMode(GameMode.ADVENTURE);
  		      p.Fser2.setGameMode(GameMode.ADVENTURE);
  		    p.wizF.getInventory().clear();
		      p.Fser1.getInventory().clear();
		      p.Fser2.getInventory().clear();
		      p.wizF.getInventory().setBoots(null);
		      p.wizF.getInventory().setLeggings(null);
		      p.wizF.getInventory().setChestplate(null);
		      p.wizF.getInventory().setHelmet(null);
		      p.Fser1.getInventory().setBoots(null);
		      p.Fser1.getInventory().setLeggings(null);
		      p.Fser1.getInventory().setChestplate(null);
		      p.Fser1.getInventory().setHelmet(null);
		      p.Fser2.getInventory().setBoots(null);
		      p.Fser2.getInventory().setLeggings(null);
		      p.Fser2.getInventory().setChestplate(null);
		      p.Fser2.getInventory().setHelmet(null);
		       }
	    if (!(event.getEntity() instanceof Player)) {
	      return;
	    }
	 Player victim = (Player)event.getEntity();
	 
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
	 }else  if(victim==p.Eser1) {
		 p.Eser1D=true;
	 }else  if(victim==p.Eser2) {
		 p.Eser2D=true;
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
	    if(killer==p.Nser1 || killer==p.Nser2 || killer==p.Pser1 || killer==p.Pser2 || killer==p.Eser1 || killer==p.Eser2 || killer==p.Fser1 || killer==p.Fser2 ) {
	    	killer.setMaxHealth(killer.getMaxHealth()+1.0F);
	    }
	    if(killer==p.wizN || killer==p.Nser1 || killer==p.Nser2) {
	    	
	        
	       /* ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
	        SkullMeta meta = (SkullMeta) item.getItemMeta();
	        meta.setOwner(victim.getName());
	        meta.setDisplayName("§c"+victim.getName()+"'s Head");
	        item.setItemMeta(meta);*/
	    	
	    	ItemStack item = new ItemStack(Material.NETHER_STAR);
	    	ItemMeta meta =item.getItemMeta();
	        meta.setDisplayName("§c"+victim.getName()+"'s Star");
	        item.setItemMeta(meta);
	    	
	        Location vloc= victim.getLocation();
	        Location hloc=new Location(victim.getWorld(), vloc.getX(), vloc.getY()+1, vloc.getZ());
	    	  victim.getWorld().dropItemNaturally(hloc, item);
	    }
	    if(killer==p.wizN) {
	    	if(victim!=p.Nser1 || victim!=p.Nser2 || victim!=p.wizE || victim!=p.wizF || victim!=p.wizP) {
	    		
	    		p.wizNZomI=victim.getName();
	    	}
	    	
	    	/*if(victim==p.Fser1 || victim==p.Fser2) {
	    		p.wizFN=true;
	    		p.wizPN=false;
	    		p.wizEN=false;
	    	}
	    	if(victim==p.Pser1 || victim==p.Pser2) {
	    		p.wizFN=false;
	    		p.wizPN=true;
	    		p.wizEN=false;
	    	}
	    	if(victim==p.Eser1 || victim==p.Eser2) {
	    		p.wizFN=false;
	    		p.wizPN=false;
	    		p.wizEN=true;
	    	}*/
	    }
	    
	}
	
	@EventHandler
    public void onTestEntityDamage(EntityDamageByEntityEvent event) {
        
		 Entity enfermé = (Entity)event.getEntity();
    	 Entity  enfermeur= (Entity)event.getDamager();
    	 ItemStack it =p.wizP.getItemInHand();
    	 
    	 
 		if(it != null) {
    	 if(it.getType()== Material.COBBLESTONE && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(WizP.nameEferme)){
    		 
    	 
		if(enfermeur==p.wizP) {
			WizP wizP = new WizP(p, main);
			wizP.enferage(enfermé);
			event.setCancelled(true);
		}
    	 }
 		}
		if (event.getDamager() instanceof Player){
		if (event.getEntity() instanceof Enderman) {
			Player Damager = (Player)event.getDamager();
			if(Damager.getWorld()==Bukkit.getWorld("worldSpawn_the_end")) {
				event.setCancelled(true);
				Damager.sendMessage("§4Les enderpearl de l'end sont interdite");
			}
		}
		}
		
		if (event.getDamager() instanceof Enderman){
			if (event.getEntity() instanceof Player) {
				Player Victim = (Player)event.getEntity();
				if(Victim.getWorld()==Bukkit.getWorld("worldSpawn_the_end")) {
					event.setCancelled(true);
				}
			}
			}
		
		if(p.fpvp==false)return;
		if(TimerTasks.Ingame==true) {
			if (event.getDamager() instanceof Player){
            if (event.getEntity() instanceof Player) {
            	 Player victim = (Player)event.getEntity();
            	 Player Damager = (Player)event.getDamager();
               
            	 if(TimerTasks.pvp==true) {
            		 if(victim==p.Nser1||victim==p.Nser2||victim==p.wizN) {
            			 if(Damager==p.Fser1||Damager==p.Fser2||Damager==p.wizF) {
            				 victim.setHealth(victim.getHealth()-1);
            				 //feu>necro
            			 }
            		 }
            		 if(victim==p.Fser1||victim==p.Fser2||victim==p.wizF) {
            			 if(Damager==p.Eser1||Damager==p.Eser2||Damager==p.wizE) {
            				 victim.setHealth(victim.getHealth()-1);
            				 //eau>feu
            			 }
            		 }
            		 if(victim==p.Pser1||victim==p.Pser2||victim==p.wizP) {
            			 if(Damager==p.Nser1||Damager==p.Nser2||Damager==p.wizN) {
            				 victim.setHealth(victim.getHealth()-1);
            				 //necro>pierre
            			 }
            		 }
            		 if(victim==p.Eser1||victim==p.Eser2||victim==p.wizE) {
            			 if(Damager==p.Pser1||Damager==p.Pser2||Damager==p.wizP) {
            				 victim.setHealth(victim.getHealth()-1);
            				 //pierre>eau
            			 }
            		 }
            		 if(victim==p.Nser1||victim==p.Nser2||victim==p.wizN) {
            			 if(Damager==p.Nser1||Damager==p.Nser2||Damager==p.wizN) {
            				 event.setCancelled(true);
            				 Damager.sendMessage("Ne frappe pas t'es alliés");
            			 }
            		 }
            		 
            		 if(victim==p.Fser1||victim==p.Fser2||victim==p.wizF) {
            			 if(Damager==p.Fser1||Damager==p.Fser2||Damager==p.wizF) {
            				 event.setCancelled(true);
            				 Damager.sendMessage("Ne frappe pas t'es alliés");
            			 }
            		 }
            		 
            		 if(victim==p.Pser1||victim==p.Pser2||victim==p.wizP) {
            			 if(Damager==p.Pser1||Damager==p.Pser2||Damager==p.wizP) {
            				 event.setCancelled(true);
            				 Damager.sendMessage("Ne frappe pas t'es alliés");
            			 }
            		 }
            		 if(victim==p.Eser1||victim==p.Eser2||victim==p.wizE) {
            			 if(Damager==p.Eser1||Damager==p.Eser2||Damager==p.wizE) {
            				 event.setCancelled(true);
            				 Damager.sendMessage("Ne frappe pas t'es alliés");
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
		if(it.getType()== Material.GOLDEN_APPLE && TimerTasks.Ingame) {
			if(it.hasItemMeta() && it.getItemMeta().hasLore()) {
				player.removePotionEffect(PotionEffectType.ABSORPTION);
				player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 5*(int)player.getMaxHealth(), 1));
				return;
			}
			player.removePotionEffect(PotionEffectType.ABSORPTION);
		player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 120*20, 1));
		player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 5*(int)player.getMaxHealth(), 1));
		}
		if(it.getType()== Material.ROTTEN_FLESH) {
			if(it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(WizN.nameForce)) {
				if(player== p.wizN) {
					event.setCancelled(true);
				ItemStack item = player.getItemInHand();
                
				ItemStack Force = new ItemStack(Material.ROTTEN_FLESH, item.getAmount()-1);
				ItemMeta customForce =Force.getItemMeta();
				customForce.setDisplayName(WizN.nameForce);//fait gaffe de le changer aussi dans la method on Interact
				customForce.setLore(Arrays.asList("§cEn mangant cette Item", "Augementer vos dégat","pendant 10s"));
				customForce.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 1, true);
				customForce.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				Force.setItemMeta(customForce);
				p.wizN.getInventory().setItemInHand(Force);
				p.wizN.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 200, 0, true));
				}else {
					player.sendMessage("§4Tu n'est pas Necromancié");
				}
			}
		}
			
		
	}
	
	@EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
		
		 if (event.getEntity() instanceof Player) {
             Player victim = (Player)event.getEntity();
            if(TimerProt.NoHurtA==true) {
                event.setCancelled(true);
            }
            if(victim==p.wizF || victim==p.Fser1 || victim==p.Fser2) {
               if(TimerProt.NoHurtF==true) {
                   event.setCancelled(true);
               }
            }
       
           
           if(victim==p.wizP || victim==p.Pser1 || victim==p.Pser2) {
               if(TimerProt.NoHurtP==true) {
                   event.setCancelled(true);
               }
            }
           
           
           if(victim==p.wizN || victim==p.Nser1 || victim==p.Nser2) {
               if(TimerProt.NoHurtN==true) {
                   event.setCancelled(true);
               }
            }
           
           if(victim==p.wizE || victim==p.Eser1 || victim==p.Eser2) {
               if(TimerProt.NoHurtE==true) {
                   event.setCancelled(true);
               }
               if(event.getCause()==DamageCause.FALL) {
            	   event.setCancelled(true);
               }
            }
           
           
           if(victim==p.wizP || victim==p.Pser1) {
               if(WizP.jumpGod==true) {
                event.setCancelled(true);
               }
           }

		
	}
        
	}
	
	@EventHandler
	public void onSignChange(SignChangeEvent event) {
		if(event.getLine(0).equalsIgnoreCase("[Wither]") && event.getLine(1).equalsIgnoreCase("horizonwolf")) {
			int x=20030;
			int y=81;
			int z=200000;
			if(event.getBlock().getLocation().getBlockX()==x && event.getBlock().getLocation().getBlockY()==y && event.getBlock().getLocation().getBlockZ()==z) {
				event.setLine(0, WizF.l1Wither);
				event.setLine(1, "§9panneaux quand");
				event.setLine(2, "§9vous etes près");
				event.setLine(3, "§9Posez bien");
				Bukkit.broadcastMessage(event.getPlayer().getName()+"A poser un panneaux custom");
			}else {
				event.setLine(0, "§4ERROR");
				event.setLine(1, "§4Les cos sont");
				event.setLine(2, "§4"+x+" "+y+" "+z);
			}
		}
		
		if(event.getLine(0).equalsIgnoreCase("[Wither2]") && event.getLine(1).equalsIgnoreCase("horizonwolf")) {
			int x=20030;
			int y=80;
			int z=200000;
			if(event.getBlock().getLocation().getBlockX()==x && event.getBlock().getLocation().getBlockY()==y && event.getBlock().getLocation().getBlockZ()==z) {
				event.setLine(0, "§9votre Stuff");
				event.setLine(1, "§9car vous");
				event.setLine(2, "§9aller etre");
				event.setLine(3, "§9/clear");
				Bukkit.broadcastMessage(event.getPlayer().getName()+"A poser un panneaux custom");
			}else {
				event.setLine(0, "§4ERROR");
				event.setLine(1, "§4Les cos sont");
				event.setLine(2, "§4"+x+" "+y+" "+z);
			}
		}
		
		if(event.getLine(0).equalsIgnoreCase("[Sortie]") && event.getLine(1).equalsIgnoreCase("horizonwolf")) {
			int x=19996;
			int y=81;
			int z=200000;
			if(event.getBlock().getLocation().getBlockX()==x && event.getBlock().getLocation().getBlockY()==y && event.getBlock().getLocation().getBlockZ()==z) {
				event.setLine(0, "§9Cliquer sur ce");
				event.setLine(1, "§9panneaux quand");
				event.setLine(2, "§9vous avez pris");
				event.setLine(3, WizF.l4Sortie);
				Bukkit.broadcastMessage(event.getPlayer().getName()+"A poser un panneaux custom");
			}else {
				event.setLine(0, "§4ERROR");
				event.setLine(1, "§4Les cos sont");
				event.setLine(2, "§4"+x+" "+y+" "+z);
			}
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		if(e.getPlayer() == Bukkit.getPlayer("d78eaf316b004a38b5c884f9068da0d8")/*Karma*/ || 
				e.getPlayer() == Bukkit.getPlayer("d60fa8019daa45ffaea53c30acd93cb8") /*Sharky080*/|| 
				e.getPlayer() == Bukkit.getPlayer("5ca542b8891446a0ae21c9c71f33bdc9")/*DiplodusPedibus*/) {
		s.getTeam("taupe").addPlayer(e.getPlayer());
		}
	}
	
	public void registerHealthBar() {
		if(s.getObjective("health") != null) {
			s.getObjective("health").unregister();
		}
		Objective o= s.registerNewObjective("health", "health");
		o.setDisplayName(ChatColor.RED+"♡");
		o.setDisplaySlot(DisplaySlot.BELOW_NAME);
	}
	
	public void registerNameTag() {
		if(s.getObjective("taupe") != null) {
			s.getObjective("taupe").unregister();
		}
	Team t = s.registerNewTeam("taupe");
	t.setPrefix(ChatColor.GRAY+"[Taupe]");
	}
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		if(e.getPlayer()==p.wizF || e.getPlayer()==p.Fser1 || e.getPlayer()==p.Fser2) {
	    Material m = e.getPlayer().getLocation().getBlock().getType();
	    if (m == Material.STATIONARY_WATER || m == Material.WATER) {
	    	e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 40, 0, true));
	    	e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 40, 0, true));
	    	e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 40, 0, true));
	    }
	    
	    if (m == Material.STATIONARY_LAVA || m == Material.LAVA) {
	    }
		}
	}
	
	

	   @EventHandler
	      public void SnowballLightning(ProjectileHitEvent event) {
		   
		   if(TimerTasks.Ingame==true) {
	          if(event.getEntity() instanceof Snowball) {
	           Snowball sb = (Snowball) event.getEntity();
	           int posX = (int)Math.floor(event.getEntity().getLocation().getX());
	           int posY = (int)Math.floor(event.getEntity().getLocation().getY());
	          int posZ = (int)Math.floor(event.getEntity().getLocation().getZ());
	          LittleThings.setBlock(null, Material.STATIONARY_WATER, posX+0, posY, posZ+0);
	          LittleThings.setBlock(null, Material.STATIONARY_WATER, posX+1, posY, posZ+0);
	          LittleThings.setBlock(null, Material.STATIONARY_WATER, posX+0, posY, posZ+1);
	          LittleThings.setBlock(null, Material.STATIONARY_WATER, posX+1, posY, posZ+1);
	          LittleThings.setBlock(null, Material.STATIONARY_WATER, posX-1, posY, posZ+0);
	          LittleThings.setBlock(null, Material.STATIONARY_WATER, posX+0, posY, posZ-1);
	          LittleThings.setBlock(null, Material.STATIONARY_WATER, posX-1, posY, posZ-1);
	          LittleThings.setBlock(null, Material.STATIONARY_WATER, posX+1, posY, posZ-1);
	          LittleThings.setBlock(null, Material.STATIONARY_WATER, posX-1, posY, posZ+1);
	          }
	 
	        
	          
	          }
	        }
	   @EventHandler
	   public void onBlockBreak(BlockBreakEvent event) {
		   if(TimerTasks.Ingame==true) {
	       Material block = event.getBlock().getType();
	       if (block == Material.SNOW || block == Material.SNOW_BLOCK) {
	            event.getBlock().setType(Material.AIR);
	           event.setCancelled(true);
	          event.getBlock().getDrops().clear();
	          event.getPlayer().sendMessage("§cLes Snowball sont interdit");
	 
	        
	      }
		   }
	   }
	   @EventHandler
	   public void templeBlockBreakTest(BlockBreakEvent event) {
		   Temple t =new Temple(p, main);
		   if(t.placeOrBreak(event.getBlock().getLocation())==false) {
			   if(event.getPlayer().getGameMode()!=GameMode.CREATIVE) {
			   event.getPlayer().sendMessage("Cette endroit et proteger");
			   event.setCancelled(true);
			   }
		   }
	   }
	   
	   @EventHandler
	   public void templeBlockPlaceTest(BlockPlaceEvent event) {
		   Temple t =new Temple(p, main);
		   if(t.placeOrBreak(event.getBlock().getLocation())==false) {
			   if(event.getPlayer().getGameMode()!=GameMode.CREATIVE) {
			   event.getPlayer().sendMessage("Cette endroit et proteger");
			   event.setCancelled(true);
			   }
		   }
	   }
	
}
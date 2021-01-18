package com.Wolf_IV.WizardUHC.tasks;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import com.Wolf_IV.WizardUHC.MainW;
import com.Wolf_IV.WizardUHC.Commands.CStart;
import com.Wolf_IV.WizardUHC.Role.WizN;

public class TimerTasks extends BukkitRunnable {
	Random rand =new Random();
	private MainW main;
	private CStart p;
	public TimerTasks(MainW mainW, CStart cStart) {
		this.main= mainW;
		this.p= cStart;
	}

public static int timerS=60;
public static int timeSec=0;
public static int timeSDay=0;
public static int timeDay=1;
public static int timeMin=0;
public static int timeH=0;
public static int jour=0;
public static int wolfch=1;
public static String timeA="0 : 0";
public static String WizUHC="Wizards UHC";
public static String WolfS="-Wolf_IV";
public static String JourSay="§ePvp Jour 4⚙";
public static boolean WizUHCb=false;
public static boolean pvp=false;
public static boolean Ingame=false;
public static boolean starting;
public static boolean stop= false;
	@Override
	public void run() {
		
		
		
		timeSDay++;
		timeSec++;
		
		if(timeSec==60) {
			timeSec=0;
			timeMin++;
			
		 if(timeMin==60) {
			timeMin=0;
			timeH++;
		}
		 
		 }
		if(timeH==0) {
			timeA="§a"+timeMin+" : "+timeSec;
		}else {
			timeA="§a"+timeH+" : "+timeMin+" : "+timeSec;
		}
		if(WizUHCb==true) {
			WizUHC="§aWizards §eUHC";
			WizUHCb=false;
		}else {
			WizUHC="§eWizards §aUHC";
			WizUHCb=true;
		}
		if(wolfch==1) {
			wolfch++;
			WolfS="§a-§bW§co§dl§ef§1_§2I§3V";
		}else if(wolfch==2) {
			wolfch++;
			WolfS="§3-§aW§bo§cl§df§e_§1I§2V";
		}else if(wolfch==3) {
			wolfch++;
			WolfS="§2-§3W§ao§bl§cf§d_§eI§1V";
		}else if(wolfch==4) {
			wolfch++;
			WolfS="§1-§2W§3o§al§bf§c_§dI§eV";
		}else if(wolfch==5) {
			wolfch++;
			WolfS="§e-§1W§2o§3l§af§b_§cI§dV";
		}else if(wolfch==6) {
			wolfch++;
			WolfS="§d-§eW§1o§2l§3f§a_§bI§cV";
		}else if(wolfch==7) {
			wolfch++;
			WolfS="§c-§dW§eo§1l§2f§3_§aI§bV";
		}else if(wolfch==8) {
			wolfch=1;
			WolfS="§b-§cW§do§el§1f§2_§3I§aV";
		}
		 
		if(timeSDay==1200) {
			 timeSDay=0;
			 timeDay++;
			 if(timeDay==4) {
				 JourSay="§eBordur Jour 5⚙";
				 Bukkit.broadcastMessage("§eJour 4⚙ PVP Activé"); 
				 pvp=true;
				 Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "gamerule keepInventory false");
			 }else if(timeDay==5){
				 JourSay="§eFin Bordur Jour 6⚙";
				 Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "worldborder set 6000");
				 Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "worldborder set 200 1200");
				 Bukkit.broadcastMessage("§eJour 5⚙ Bordur 3000 block elle serat a 100 block d'ici Jour 6⚙"); 
			 }else if(timeDay==6){
				 JourSay="§eExplosive_Titan le bg";
				 Bukkit.broadcastMessage("§eJour 6⚙ La Bordur c'est aréter a 100blocks"); 
			 }else {
			 
				 Bukkit.broadcastMessage("§eJour "+timeDay+"⚙"); 
			 }
			 }
		
	
		
		
	if(timerS>0) {
			Bukkit.broadcastMessage("§eLancement de l'UHC dans §2"+timerS+"s");
			timerS--;
			if(stop==true) {
				Bukkit.broadcastMessage("§4Lancement du UHC Annulé");
				stop=false;
				Ingame=false;
				cancel();
			}
		} else if(timerS==0) {
			Bukkit.broadcastMessage("§eLancement de l'UHC");
			timerS--;
			starting=false;
		
			Location block =new Location(Bukkit.getWorld("worldSpawn"), 0, 120, 0);
			for(int ix=-100; ix<100; ix++) {
				for(int iz=-100; iz<100; iz++) {
				block = new Location(Bukkit.getWorld("worldSpawn"), ix, 120, iz);
				block.getBlock().setType(Material.AIR);
				
				
				}
				
				}
		
			/**
			 * TP ALL
			 */
			/*
			Bukkit.broadcastMessage("Equipe Necromancié "+p.Nser1.getName()+" et "+p.Nser2.getName());
			Bukkit.broadcastMessage("Equipe Feu "+p.Fser1.getName()+" et "+p.Fser2.getName());
			Bukkit.broadcastMessage("Equipe Pierre "+p.Pser1.getName()+" et "+p.Pser2.getName());*/
			
			Location tp =new Location(Bukkit.getWorld("worldSpawn"), rand.nextInt(1000)-500+20000, 255, rand.nextInt(1000)-500, 0, 0);
				
				p.Fser1.teleport(tp);
				p.Fser2.teleport(tp);
				tp =new Location(Bukkit.getWorld("worldSpawn"), rand.nextInt(1000)-500+20000, 255, rand.nextInt(1000)-500, 0, 0);
				p.Nser1.teleport(tp);
				p.Nser2.teleport(tp);
				tp =new Location(Bukkit.getWorld("worldSpawn"), rand.nextInt(1000)-500+20000, 255, rand.nextInt(1000)-500, 0, 0);
				p.Pser1.teleport(tp);
				p.Pser2.teleport(tp);
				tp =new Location(Bukkit.getWorld("worldSpawn"), rand.nextInt(1000)-500+20000, 255, rand.nextInt(1000)-500, 0, 0);
				p.Eser1.teleport(tp);
				p.Eser2.teleport(tp);
				tp =new Location(Bukkit.getWorld("worldSpawn"), rand.nextInt(2000)-1000, 255, rand.nextInt(2000)-1000, 0, 0);
				p.wizF.teleport(tp);
				p.wizF.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 0, true));
				p.wizF.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999, 0, true));
				tp =new Location(Bukkit.getWorld("worldSpawn"), rand.nextInt(500)-250, 255, rand.nextInt(500)-250, 0, 0);
				p.wizN.teleport(tp);
				p.wizN.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999, 1, true));
				p.wizN.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 999999, 0, true));
				tp =new Location(Bukkit.getWorld("worldSpawn"), rand.nextInt(500)-250, 255, rand.nextInt(500)-250, 0, 0);
				p.wizP.teleport(tp);
				p.wizN.setMaxHealth(p.wizN.getMaxHealth()+8.0F);
				p.wizP.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 20, 100, true));
				p.wizP.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 999999, 1, true));
				tp =new Location(Bukkit.getWorld("worldSpawn"), rand.nextInt(500)-250, 255, rand.nextInt(500)-250, 0, 0);
				p.wizE.teleport(tp);
				p.wizE.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 999999, 0, true));
				
				p.Fser1.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 0, true));
				p.Fser1.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999, 0, true));
				p.Nser1.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999, 1, true));
				p.Nser1.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 999999, 0, true));
				//p.Pser1.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 999999, 1, true));
				p.Pser1.setMaxHealth(p.Pser1.getMaxHealth()+8.0F);
				p.Pser1.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 20, 100, true));
				p.Pser1.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 999999, 1, true));
				p.Eser1.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 999999, 0, true));
				p.Fser2.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 0, true));
				p.Fser2.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999, 0, true));
				p.Nser2.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999, 1, true));
				p.Nser2.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 999999, 0, true));
				p.Pser2.setMaxHealth(p.Pser2.getMaxHealth()+8.0F);
				p.Pser2.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 20, 200, true));
				p.Pser2.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 999999, 1, true));
				p.Eser2.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 999999, 0, true));
				//si change E change aussi dans revive
				Bukkit.broadcastMessage("Bienvenue sur Wizards Uhc");
				p.Fser1.setGameMode(GameMode.SURVIVAL);
                p.Nser1.setGameMode(GameMode.SURVIVAL);
                p.Pser1.setGameMode(GameMode.SURVIVAL);
                p.Eser1.setGameMode(GameMode.SURVIVAL);
                p.Fser2.setGameMode(GameMode.SURVIVAL);
                p.Nser2.setGameMode(GameMode.SURVIVAL);
                p.Pser2.setGameMode(GameMode.SURVIVAL);
                p.Eser2.setGameMode(GameMode.SURVIVAL);
                p.wizN.setGameMode(GameMode.SURVIVAL);
                p.wizP.setGameMode(GameMode.SURVIVAL);
                p.wizF.setGameMode(GameMode.SURVIVAL);
                p.wizE.setGameMode(GameMode.SURVIVAL);
                p.wizF.getInventory().clear();
                p.Fser1.getInventory().clear();
                p.Fser2.getInventory().clear();
                p.wizN.getInventory().clear();
                p.Nser1.getInventory().clear();
                p.Nser2.getInventory().clear();
                p.wizP.getInventory().clear();
                p.Pser1.getInventory().clear();
                p.Pser2.getInventory().clear();
                p.wizE.getInventory().clear();
                p.Eser1.getInventory().clear();
                p.Eser2.getInventory().clear();
                
                p.wizF.setMaxHealth(20.0F);
                p.Fser1.setMaxHealth(20.0F);
                p.Fser2.setMaxHealth(20.0F);
                p.wizN.setMaxHealth(20.0F);
                p.Nser1.setMaxHealth(20.0F);
                p.Nser2.setMaxHealth(20.0F);
                p.wizP.setMaxHealth(20.0F);
                p.Pser1.setMaxHealth(20.0F);
                p.Pser2.setMaxHealth(20.0F);
                p.wizE.setMaxHealth(20.0F);
                p.Eser1.setMaxHealth(20.0F);
                p.Eser2.setMaxHealth(20.0F);
                
                p.wizF.sendMessage("§1Vous etes scorcier de Feu");
                p.Fser1.sendMessage("§1Vous etes serviteur de Feu");
                p.Fser2.sendMessage("§1Vous etes serviteur de Feu");
                p.wizE.sendMessage("§1Vous etes scorcier d'Eau");
                p.Eser1.sendMessage("§1Vous etes serviteur d'Eau");
                p.Eser2.sendMessage("§1Vous etes serviteur d'Eau");
                p.wizP.sendMessage("§1Vous etes scorcier de Pierre");
                p.Pser1.sendMessage("§1Vous etes serviteur de Pierre");
                p.Pser2.sendMessage("§1Vous etes serviteur de Pierre");
                p.wizN.sendMessage("§1Vous etes scorcier de Necromancié");
                p.Nser1.sendMessage("§1Vous etes serviteur de Nercomancié");
                p.Nser2.sendMessage("§1Vous etes serviteur de Necromancié");
                ItemStack DE = new ItemStack(Material.ENCHANTED_BOOK);
    			ItemMeta customDE = DE.getItemMeta();
    			customDE.addEnchant(Enchantment.DEPTH_STRIDER, 3, true);
    			DE.setItemMeta(customDE);
                p.Eser1.getInventory().setItemInHand(DE);
                p.Eser2.getInventory().setItemInHand(DE);
                p.wizE.getInventory().setItemInHand(DE);
                TimerProt tasks = new TimerProt();
                tasks.runTaskTimer(main, 0, 20);
                TimerProt.timerFallA=30;
               
                
			/**
			 * TP ALL
			 */
				
				
				
				
				
			
			}//end start
	
	if(this.timeSDay>3) {
		
        p.resetBoard();
		 ScoreboardManager scoreM = Bukkit.getScoreboardManager();
		Scoreboard score = scoreM.getNewScoreboard();
		if(score.getObjective("health") != null) {
			score.getObjective("health").unregister();
		}
		Objective oH= score.registerNewObjective("health", "health");
		oH.setDisplayName(ChatColor.RED+"♡");
		oH.setDisplaySlot(DisplaySlot.BELOW_NAME);
		
		Objective o = score.registerNewObjective("Debut", "Pvp");
		o.setDisplaySlot(DisplaySlot.SIDEBAR);
		o.setDisplayName(WizUHC);
		Score temps = o.getScore("§bTemps Passé: "+timeA);
		//Score debut2 = o.getScore("voir le temps écoulrré");
		Score pvp = o.getScore(JourSay);
		Score wolf = o.getScore(WolfS);
		Score WU = o.getScore("      "+WizUHC);
		temps.setScore(4);
		//debut2.setScore(3);
		pvp.setScore(3);
		wolf.setScore(2);
		WU.setScore(1);
		
		
		for (Player playerO : Bukkit.getServer().getOnlinePlayers()) {
			playerO.setScoreboard(score);
			}
		
		/*p.wizN.setScoreboard(score);
		p.wizP.setScoreboard(score);
		p.wizF.setScoreboard(score);
		p.ser1.setScoreboard(score);
		p.ser2.setScoreboard(score);
		p.ser3.setScoreboard(score);
		p.ser4.setScoreboard(score);
		p.ser5.setScoreboard(score);
		p.ser6.setScoreboard(score);*/
		
		
        }
		
		
		
	
	
	}
	
	

}
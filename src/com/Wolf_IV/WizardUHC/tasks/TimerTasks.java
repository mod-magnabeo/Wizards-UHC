package com.Wolf_IV.WizardUHC.tasks;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
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

public static int timerS=10;
public static int timeSec=-60*20;
public static int timeSDay=0;
public static int timeDay=0;
public static int timeMin=0;
public static int timeH=0;
public static int jour=0;
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
			Bukkit.broadcastMessage(timeSec+":"+timeMin);
			
		 if(timeMin==60) {
			timeMin=0;
			timeH++;
		}
		 
		 }
		 
		if(timeSDay==2700) {
			 timeSDay=0;
			 timeDay++;
			 if(timeDay==3) {
				 Bukkit.broadcastMessage("§eJour 3 PVP Activé"); 
				 pvp=true;
				 Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "gamerule keepInventory false");
			 }else {
				 Bukkit.broadcastMessage("§eJour "+timeDay); 
			 }
			 }
		
		
	
	
		
		
	if(timerS>0) {
			Bukkit.broadcastMessage("Lancement de l'UHC dans "+timerS+"s");
			timerS--;
			if(stop==true) {
				Bukkit.broadcastMessage("Lancement du UHC Annulé");
				stop=false;
				Ingame=false;
				cancel();
			}
		} else if(timerS==0) {
			Bukkit.broadcastMessage("Lancement de l'UHC");
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
			Bukkit.broadcastMessage("Equipe Necromancié "+p.Nser1.getName()+" et "+p.Nser2.getName());
			Bukkit.broadcastMessage("Equipe Feu "+p.Fser1.getName()+" et "+p.Fser2.getName());
			Bukkit.broadcastMessage("Equipe Pierre "+p.Pser1.getName()+" et "+p.Pser2.getName());
			
				Location tp =new Location(Bukkit.getWorld("worldSpawn"), rand.nextInt(2000)-1000, 80, rand.nextInt(2000)-1000, 0, 0);
				p.wizF.teleport(tp);
				p.wizF.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100000, 0, true));
				p.wizF.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 100000, 0, true));
				tp =new Location(Bukkit.getWorld("worldSpawn"), rand.nextInt(2000)-1000, 80, rand.nextInt(2000)-1000, 0, 0);
				p.wizN.teleport(tp);
				p.wizN.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100000, 1, true));
				p.wizN.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 100000, 1, true));
				tp =new Location(Bukkit.getWorld("worldSpawn"), rand.nextInt(2000)-1000, 80, rand.nextInt(2000)-1000, 0, 0);
				p.wizP.teleport(tp);
				p.wizP.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 100000, 1, true));
				p.wizP.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 20, 100, true));
				tp =new Location(Bukkit.getWorld("worldSpawn"), rand.nextInt(200000)-1000, 80, rand.nextInt(2000)-1000, 0, 0);
				p.ser1.teleport(tp);
				tp =new Location(Bukkit.getWorld("worldSpawn"), rand.nextInt(200000)-1000, 80, rand.nextInt(2000)-1000, 0, 0);
				p.ser2.teleport(tp);
				tp =new Location(Bukkit.getWorld("worldSpawn"), rand.nextInt(200000)-1000, 80, rand.nextInt(2000)-1000, 0, 0);
				p.ser3.teleport(tp);
				tp =new Location(Bukkit.getWorld("worldSpawn"), rand.nextInt(200000)-1000, 80, rand.nextInt(2000)-1000, 0, 0);
				p.ser4.teleport(tp);
				tp =new Location(Bukkit.getWorld("worldSpawn"), rand.nextInt(200000)-1000, 80, rand.nextInt(2000)-1000, 0, 0);
				p.ser5.teleport(tp);
				tp =new Location(Bukkit.getWorld("worldSpawn"), rand.nextInt(200000)-1000, 80, rand.nextInt(2000)-1000, 0, 0);
				p.ser6.teleport(tp);
				p.Fser1.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100000, 0, true));
				p.Fser1.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 100000, 0, true));
				p.Nser1.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100000, 1, true));
				p.Nser1.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 100000, 1, true));
				p.Pser1.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 100000, 1, true));
				p.Pser1.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 20, 100, true));
				p.Fser2.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100000, 0, true));
				p.Fser2.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 100000, 0, true));
				p.Nser2.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100000, 1, true));
				p.Nser2.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 100000, 1, true));
				p.Pser2.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 100000, 1, true));
				p.Pser2.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 20, 200, true));
				p.wizN.getInventory().setItemInHand(new ItemStack(Material.ARROW,48));
				p.Nser1.getInventory().setItemInHand(new ItemStack(Material.ARROW,48));
				Bukkit.broadcastMessage("Bienvenue sur Wizards Uhc");
			/**
			 * TP ALL
			 */
				
				
				
				
				
			
			}//end start
		
		
		
	
	
	}
	
	

}

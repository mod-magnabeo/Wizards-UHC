package com.Wolf_IV.UHC;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import com.Wolf_IV.UHC.TimerTasks;

public class TimerTasks extends BukkitRunnable {
	private MainUHC main;
	public TimerTasks(MainUHC mainUHC) {
	this.main =mainUHC;
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
	public static String JourSay="§ePvp Jour 2⚙";
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
			WizUHC="§eUHC";
			WizUHCb=false;
		}else {
			WizUHC="§aUHC";
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
			 if(timeDay==2) {
				 JourSay="§eBordur Jour 4⚙";
				 Bukkit.broadcastMessage("§eJour 2⚙ PVP Activé"); 
				 pvp=true;
				 Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "gamerule keepInventory false");
			 }else if(timeDay==4){
				 JourSay="§eFin Bordur Jour 5⚙";
				 Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "worldborder set 6000");
				 Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "worldborder set 200 1200");
				 Bukkit.broadcastMessage("§eJour 4⚙ Bordur 3000 block elle serat a 100 block d'ici Jour 5⚙"); 
			 }else if(timeDay==5){
				 JourSay="§eBonne chance a tous";
				 Bukkit.broadcastMessage("§eJour 5⚙ La Bordur c'est aréter a 100blocks"); 
			 }else {
			 
				 Bukkit.broadcastMessage("§eJour "+timeDay+"⚙"); 
			 }
			 }
		
	
	
		
		
	if(timerS>0) {
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
			for (Player playerO : Bukkit.getServer().getOnlinePlayers()) {
				playerO.getInventory().clear();
				playerO.setHealth(20);
				playerO.setFoodLevel(20);
				playerO.setGameMode(GameMode.SURVIVAL);
			}
			Random rand=new Random();
			Location tp =new Location(Bukkit.getWorld("worldSpawn"), rand.nextInt(1000)-500, 255, rand.nextInt(1000)-500, 0, 0);
			
			if(UHCListener.TB1!=null)UHCListener.TB1.teleport(tp);
			
			if(UHCListener.TB2!=null)UHCListener.TB2.teleport(tp);
			tp =new Location(Bukkit.getWorld("worldSpawn"), rand.nextInt(1000)-500, 255, rand.nextInt(1000)-500, 0, 0);
			if(UHCListener.TV1!=null)UHCListener.TV1.teleport(tp);
			if(UHCListener.TV2!=null)UHCListener.TV2.teleport(tp);
			tp =new Location(Bukkit.getWorld("worldSpawn"), rand.nextInt(1000)-500, 255, rand.nextInt(1000)-500, 0, 0);
			if(UHCListener.TN1!=null)UHCListener.TN1.teleport(tp);
			if(UHCListener.TN2!=null)UHCListener.TN2.teleport(tp);
			tp =new Location(Bukkit.getWorld("worldSpawn"), rand.nextInt(1000)-500, 255, rand.nextInt(1000)-500, 0, 0);
			if(UHCListener.TM1!=null)UHCListener.TM1.teleport(tp);
			if(UHCListener.TM2!=null)UHCListener.TM2.teleport(tp);
			tp =new Location(Bukkit.getWorld("worldSpawn"), rand.nextInt(1000)-500, 255, rand.nextInt(1000)-500, 0, 0);
			if(UHCListener.TJ1!=null)UHCListener.TJ1.teleport(tp);
			if(UHCListener.TJ2!=null)UHCListener.TJ2.teleport(tp);
			
				
                TimerProt tasks = new TimerProt();
                tasks.runTaskTimer(main, 0, 20);
                TimerProt.timerFallA=30;
               
                
			/**
			 * TP ALL
			 */
				
				
				
				
				
			
			}//end start
	
	if(this.timeSDay>3) {
		
		 ScoreboardManager scoreM = Bukkit.getScoreboardManager();
		Scoreboard score = scoreM.getNewScoreboard();
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

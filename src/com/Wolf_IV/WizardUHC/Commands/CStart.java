package com.Wolf_IV.WizardUHC.Commands;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import com.Wolf_IV.WizardUHC.MainW;
import com.Wolf_IV.WizardUHC.WListeners;
import com.Wolf_IV.WizardUHC.tasks.TimerTasks;
import com.Wolf_IV.WizardUHC.Role.WizF;
import com.Wolf_IV.WizardUHC.Role.WizN;
import com.Wolf_IV.WizardUHC.Role.WizP;

public class CStart implements CommandExecutor {
	//public Player play[]=new Player[8];
	Random rand = new Random();
	public Player wizN ;
	public Player wizF;
	public Player wizP;
	public Player ser1;
	public Player ser2;
	public Player ser3;
	public Player ser4;
	public Player ser5;
	public Player ser6;
	public Player Nser1;
	public Player Nser2;
	public Player Fser1;
	public Player Fser2;
	public Player Pser1;
	public Player Pser2;
	public boolean Nser1D=false;
	public boolean Nser2D=false;
	public boolean Fser1D=false;
	public boolean Fser2D=false;
	public boolean Pser1D=false;
	public boolean Pser2D=false;
	public boolean wizPN=false;
	public boolean wizFN=false;
	public Player NZom;
	public ScoreboardManager scoreM = Bukkit.getScoreboardManager();
	public Scoreboard score = scoreM.getNewScoreboard();
	public Team Nteam = score.registerNewTeam("Necromancie");
	public Team Fteam = score.registerNewTeam("Feu");
	public Team Pteam = score.registerNewTeam("Pierre");

	
	private static MainW main;
	public CStart(MainW mainW) {
		this.main= mainW;
		
	}
	
	
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if(sender instanceof Player) {
			if(cmd.getName().equalsIgnoreCase("start")) {
			Player player = (Player)sender;
			Bukkit.broadcastMessage("§cLancement de Wizards Uhc");
			Bukkit.broadcastMessage("§cDeveloper par:");
			Bukkit.broadcastMessage("§c-Wolf_IV");
			Bukkit.broadcastMessage("");
			TimerTasks.pvp=false;
			TimerTasks.Ingame=true;
			 Nser1D=false;
			 Nser2D=false;
			 Fser1D=false;
			 Fser2D=false;
			 Pser1D=false;
			 Pser2D=false;
			 wizPN=false;
			 wizFN=false;
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "gamerule keepInventory true");
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "time set day");
			
				
			if(createPlayer() ==true) {
			TimerTasks tasks = new TimerTasks(main, this);
				tasks.runTaskTimer(main, 0, 20);
				TimerTasks.starting=true;
				setScoreTeam();
			}else {
				player.sendMessage("§4 Il y a un probleme dans la config. Les pseudo sont mal engitrer");
			}
				
			
			
			
			return true;
			}
		}
		return false;
	}
	
	public boolean createPlayer() {//start
		Player ser[]= new Player[6];
		int i;
		 int rando;
		 int choose;
		 int choose2;
		 Player container;
		 
		
		if(Bukkit.getPlayer(main.getConfig().getString("wizard.player.wizF")) !=null){
			wizF = Bukkit.getPlayer(main.getConfig().getString("wizard.player.wizF"));
			//play[0]= main.getConfig().getString("wizard.player.wizF");
		}else {return false;}
		
		if(Bukkit.getPlayer(main.getConfig().getString("wizard.player.wizN")) !=null){
			wizN = Bukkit.getPlayer(main.getConfig().getString("wizard.player.wizN"));
			//play[1]= wizN;
		}else {return false;}
		
		if(Bukkit.getPlayer(main.getConfig().getString("wizard.player.wizP")) !=null){
			wizP = Bukkit.getPlayer(main.getConfig().getString("wizard.player.wizP"));
			//play[2]= wizP;
		}else {return false;}
		
		if(Bukkit.getPlayer(main.getConfig().getString("wizard.player.ser1")) !=null){
			ser1 = Bukkit.getPlayer(main.getConfig().getString("wizard.player.ser1"));
			//play[3]= ser1;
			ser[0]=ser1;
		}else {return false;}
		
		if(Bukkit.getPlayer(main.getConfig().getString("wizard.player.ser2")) !=null){
			ser2 = Bukkit.getPlayer(main.getConfig().getString("wizard.player.ser2"));
			//play[4]= ser2;
			ser[1]=ser2;
		}else {return false;}
		
		if(Bukkit.getPlayer(main.getConfig().getString("wizard.player.ser3")) !=null){
			ser3 = Bukkit.getPlayer(main.getConfig().getString("wizard.player.ser3"));
			//play[5]= ser3;
			ser[2]=ser3;
		}else {return false;}
		
		if(Bukkit.getPlayer(main.getConfig().getString("wizard.player.ser4")) !=null){
			ser4 = Bukkit.getPlayer(main.getConfig().getString("wizard.player.ser4"));
			//play[6]= ser4;
			ser[3]=ser4;
		}else {return false;}
		
		if(Bukkit.getPlayer(main.getConfig().getString("wizard.player.ser5")) !=null){
			ser5 = Bukkit.getPlayer(main.getConfig().getString("wizard.player.ser5"));
			//play[7]= ser5;
			ser[4]=ser5;
		}else {return false;}
		
		if(Bukkit.getPlayer(main.getConfig().getString("wizard.player.ser6")) !=null){
			ser6 = Bukkit.getPlayer(main.getConfig().getString("wizard.player.ser6"));
			//play[7]= ser5;
			ser[5]=ser6;
		}else {return false;}
		
		 rando=rand.nextInt(500)+75;
			for(i=0;i<=rando;i++) {
				choose=rand.nextInt(6);
				choose2=rand.nextInt(6);
				container=ser[choose2];
				ser[choose2]=ser[choose];
				ser[choose]=container;
				}
			
			
			Nser1=ser[0];
			Nser2=ser[1];
			Fser1=ser[2];
			Fser2=ser[3];
			Pser1=ser[4];
			Pser2=ser[5];
		
		
		return true;
	}//end*/
	private void setScoreTeam() {
		Objective o = score.registerNewObjective("Debut", "Pvp");
		o.setDisplaySlot(DisplaySlot.SIDEBAR);
		o.setDisplayName("§4 Wizards UHC");
		Score debut = o.getScore("Faite /timeS pour ");
		Score debut2 = o.getScore("voir le temps écoulé");
		Score pvp = o.getScore("Pvp Jour 3");
		Score wolf = o.getScore("-Wolf_IV");
		debut.setScore(4);
		debut2.setScore(3);
		pvp.setScore(2);
		wolf.setScore(1);
		wizN.setScoreboard(score);
		wizP.setScoreboard(score);
		wizF.setScoreboard(score);
		ser1.setScoreboard(score);
		ser2.setScoreboard(score);
		ser3.setScoreboard(score);
		ser4.setScoreboard(score);
		ser5.setScoreboard(score);
		ser6.setScoreboard(score);
		
		
		Nteam.addPlayer(wizN);
		Nteam.addPlayer(Nser1);
		Nteam.addPlayer(Nser2);
		Nteam.setAllowFriendlyFire(false);
		Pteam.addPlayer(wizP);
		Pteam.addPlayer(Pser1);
		Pteam.addPlayer(Pser2);
		Pteam.setAllowFriendlyFire(false);
		Fteam.addPlayer(wizF);
		Fteam.addPlayer(Fser1);
		Fteam.addPlayer(Fser2);
		Fteam.setAllowFriendlyFire(false);
		
	}

}

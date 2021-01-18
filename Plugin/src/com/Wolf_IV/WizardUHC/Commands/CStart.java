package com.Wolf_IV.WizardUHC.Commands;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import com.Wolf_IV.WizardUHC.MainW;
import com.Wolf_IV.WizardUHC.WListeners;
import com.Wolf_IV.WizardUHC.tasks.RoleShuffle;
import com.Wolf_IV.WizardUHC.tasks.TimerTasks;
import com.Wolf_IV.WizardUHC.Role.Temple;
import com.Wolf_IV.WizardUHC.Role.WizF;
import com.Wolf_IV.WizardUHC.Role.WizN;
import com.Wolf_IV.WizardUHC.Role.WizP;

public class CStart implements CommandExecutor {
	//public Player play[]=new Player[8];
	Random rand = new Random();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Player wizN ;
	public Player wizF;
	public Player wizP;
	public Player wizE;
	public Player ser1;
	public Player ser2;
	public Player ser3;
	public Player ser4;
	public Player ser5;
	public Player ser6;
	public Player ser7;
	public Player ser8;
	public String wizNNa ;
	public String wizFNa;
	public String wizPNa;
	public String wizENa;
	public String Nser1Na;
	public String Nser2Na;
	public String Pser1Na;
	public String Pser2Na;
	public String Fser1Na;
	public String Fser2Na;
	public String Eser1Na;
	public String Eser2Na;
	public Player Nser1;
	public Player Nser2;
	public Player Fser1;
	public Player Fser2;
	public Player Pser1;
	public Player Pser2;
	public Player Eser1;
	public Player Eser2;
	public Player NPser1;
	public Player NPser2;
	public Player FPser1;
	public Player FPser2;
	public Player PPser1;
	public Player PPser2;
	public Player EPser1;
	public Player EPser2;
	public boolean Nser1D=false;
	public boolean Nser2D=false;
	public boolean Fser1D=false;
	public boolean Fser2D=false;
	public boolean Pser1D=false;
	public boolean Pser2D=false;
	public boolean Eser1D=false;
	public boolean Eser2D=false;
	public String wizNZomI=null;
	public boolean wizPN=false;
	public boolean wizFN=false;
	public boolean wizEN=false;
	public static boolean fpvp=true;
	public Player NZom;
	public ScoreboardManager scoreM = Bukkit.getScoreboardManager();
	public Scoreboard score = scoreM.getNewScoreboard();
	public Team Nteam = score.registerNewTeam("Necromancie");
	public Team Fteam = score.registerNewTeam("Feu");
	public Team Pteam = score.registerNewTeam("Pierre");
	public Team Eteam = score.registerNewTeam("Eau");

	
	private static MainW main;
	public CStart(MainW mainW) { 
		this.main= mainW;
		
	}
	
	
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if(sender instanceof Player) {
			if(cmd.getName().equalsIgnoreCase("startwiz")) {
				MainW.ingame=true;
				Temple.EUse=false;
			Player player = (Player)sender;
			Bukkit.broadcastMessage("§eLancement de §1Wizards §aUHC");
			Bukkit.broadcastMessage("§eDeveloper par:");
			Bukkit.broadcastMessage("§6-Wolf_IV");
			Bukkit.broadcastMessage("");
			TimerTasks.pvp=false;
			TimerTasks.Ingame=true;
			WizP.jumpGod=false;
			 Nser1D=false;
			 Nser2D=false; 
			 Fser2D=false;
			 Pser1D=false;
			 Pser2D=false;
			 Eser1D=false;
			 Eser2D=false;
			 wizPN=false;
			 wizFN=false;
			 wizEN=false;
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "gamerule keepInventory true");
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "time set day");
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "gamerule naturalRegeneration false");
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "difficulty easy");
			
				
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
		Player ser[]= new Player[8];
		int i;
		 int rando;
		 int choose;
		 int choose2;
		 Player container;
		 
		
		
		
		 
		/*E1p1 = main.getConfig().getString("wizard.player.E1p1");

		E1p2 = main.getConfig().getString("wizard.player.E1p2");

		E1p3 = main.getConfig().getString("wizard.player.E1p3");
		
		 
		E2p1 = main.getConfig().getString("wizard.player.E2p1");

		E2p2 = main.getConfig().getString("wizard.player.E2p2");

		E2p3 = main.getConfig().getString("wizard.player.E2p3");

		 
		E3p1 = main.getConfig().getString("wizard.player.E3p1");

		E3p2 = main.getConfig().getString("wizard.player.E3p2");

		E3p3 = main.getConfig().getString("wizard.player.E3p3");

		 
		E4p1 = main.getConfig().getString("wizard.player.E4p1");

		E4p2 = main.getConfig().getString("wizard.player.E4p2");

		E4p3 = main.getConfig().getString("wizard.player.E4p3");
		
		
		
		j1 = main.getConfig().getString("wizard.player.j1");
		
		j2 = main.getConfig().getString("wizard.player.j2");
		
		j3 = main.getConfig().getString("wizard.player.j3");
		
		j4 = main.getConfig().getString("wizard.player.j4");
		
		j5 = main.getConfig().getString("wizard.player.j5");
		
		j6 = main.getConfig().getString("wizard.player.j6");
		
		j7 = main.getConfig().getString("wizard.player.j7");
		
		j8 = main.getConfig().getString("wizard.player.j8");
		
		j9 = main.getConfig().getString("wizard.player.j9");
		
		j10 = main.getConfig().getString("wizard.player.j10");
		
		j11 = main.getConfig().getString("wizard.player.j11");
		
		j12 = main.getConfig().getString("wizard.player.j12");*/
		
		
		
			 
			
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
			
			if(Bukkit.getPlayer(main.getConfig().getString("wizard.player.wizE")) !=null){
				wizE = Bukkit.getPlayer(main.getConfig().getString("wizard.player.wizE"));
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
				//play[5]= ser3; a
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
			
			if(Bukkit.getPlayer(main.getConfig().getString("wizard.player.ser7")) !=null){
				ser7 = Bukkit.getPlayer(main.getConfig().getString("wizard.player.ser7"));
				//play[7]= ser5;
				ser[6]=ser7;
			}else {return false;}
			
			if(Bukkit.getPlayer(main.getConfig().getString("wizard.player.ser8")) !=null){
				ser8 = Bukkit.getPlayer(main.getConfig().getString("wizard.player.ser8"));
				//play[7]= ser5;
				ser[7]=ser8;
			}else {return false;}
			
			 
				
				
				Nser1=ser[0];
				Nser2=ser[1];
				Fser1=ser[2];
				Fser2=ser[3];
				Pser1=ser[4];
				Pser2=ser[5];
				Eser1=ser[6];
				Eser2=ser[7];
				
				RoleShuffle shuffler =new RoleShuffle(main);
				shuffler.Shuffle();
				
				if(shuffler.SwizP !=null){
				wizP=Bukkit.getPlayer(shuffler.SwizP);
				}else {return false;}
				
				if(shuffler.SwizE !=null){
					wizE=Bukkit.getPlayer(shuffler.SwizE);
					}else {return false;}
				
				if(shuffler.SwizN !=null){
					wizN=Bukkit.getPlayer(shuffler.SwizN);
					}else {return false;}
				
				if(shuffler.SwizF !=null){
					wizF=Bukkit.getPlayer(shuffler.SwizF);
					}else {return false;}
				
				if(shuffler.SPser1 !=null){
					Pser1=Bukkit.getPlayer(shuffler.SPser1);
					}else {return false;}
				
				if(shuffler.SPser2 !=null){
					Pser2=Bukkit.getPlayer(shuffler.SPser2);
					}else {return false;}
				
				if(shuffler.SEser1 !=null){
					Eser1=Bukkit.getPlayer(shuffler.SEser1);
					}else {return false;}
				
				if(shuffler.SEser2 !=null){
					Eser2=Bukkit.getPlayer(shuffler.SEser2);
					}else {return false;}
				
				if(shuffler.SNser1 !=null){
					Nser1=Bukkit.getPlayer(shuffler.SNser1);
					}else {return false;}
				
				if(shuffler.SNser2 !=null){
					Nser2=Bukkit.getPlayer(shuffler.SNser2);
					}else {return false;}
				
				if(shuffler.SFser1 !=null){
					Fser1=Bukkit.getPlayer(shuffler.SFser1);
					}else {return false;}
				
				if(shuffler.SFser2 !=null){
					Fser2=Bukkit.getPlayer(shuffler.SFser2);
					}else {return false;}
				
				wizFNa=wizF.getName();
				wizNNa=wizN.getName();
				wizPNa=wizP.getName();
				wizENa=wizE.getName();
				Fser1Na=Fser1.getName();
				Fser2Na=Fser2.getName();
				Nser1Na=Nser1.getName();
				Nser2Na=Nser2.getName();
				Pser1Na=Pser1.getName();
				Pser2Na=Pser2.getName();
				Eser1Na=Eser1.getName();
				Eser2Na=Eser2.getName();
			
			
			return true;
		
		
		
		
		
		
		
		/*if(Bukkit.getPlayer(SwizF) !=null){
		wizF = Bukkit.getPlayer(SwizF);
	}else {erreurPseudo=true;}
		
		
		if(Bukkit.getPlayer(SwizE) !=null){
			wizE = Bukkit.getPlayer(SwizE);
		}else {erreurPseudo=true;}
		
		
		if(Bukkit.getPlayer(SwizP) !=null){
			wizP = Bukkit.getPlayer(SwizP);
		}else {erreurPseudo=true;}
		
		
		if(Bukkit.getPlayer(SwizN) !=null){
			wizN = Bukkit.getPlayer(SwizN);
		}else {erreurPseudo=true;}
		
		
		if(Bukkit.getPlayer(SFser1) !=null){
			Fser1 = Bukkit.getPlayer(SFser1);
		}else {erreurPseudo=true;}
		
		
		if(Bukkit.getPlayer(SFser2) !=null){
			Fser2 = Bukkit.getPlayer(SFser2);
		}else {erreurPseudo=true;}
		
		
		if(Bukkit.getPlayer(SEser1) !=null){
			Eser1 = Bukkit.getPlayer(SEser1);
		}else {erreurPseudo=true;}
		
		
		if(Bukkit.getPlayer(SEser2) !=null){
			Eser2 = Bukkit.getPlayer(SEser2);
		}else {erreurPseudo=true;}
		
		
		if(Bukkit.getPlayer(SPser1) !=null){
			Pser1 = Bukkit.getPlayer(SPser1);
		}else {erreurPseudo=true;}
		
		
		if(Bukkit.getPlayer(SPser2) !=null){
			Pser2 = Bukkit.getPlayer(SPser2);
		}else {erreurPseudo=true;}
		
		
		if(Bukkit.getPlayer(SNser1) !=null){
			Nser1 = Bukkit.getPlayer(SNser1);
		}else {erreurPseudo=true;}
		
		
		if(Bukkit.getPlayer(SNser2) !=null){
			Nser2 = Bukkit.getPlayer(SNser2);
		}else {erreurPseudo=true;}*/
		
		
			
			
		
		
		
		
		
	/*	if(erreurNull==true) {
			Bukkit.broadcastMessage("§bLe problem vient de null mal mit dans la config");
			return false;
		}else if(erreurPseudo==true) {
			Bukkit.broadcastMessage("§bLe problem vient d'un pseudo mal ecrit ou bien un joueur deconecté");
			return false;
		}*/
		
		
		
		
		/**
		 * Garenti une deconection possible
		 */
		
		
		/**
		 * Garenti une deconection possible
		 */
		
		
	
		
		
		
		
		
		
		/* rando=rand.nextInt(25)+5;
			for(i=0;i<=rando;i++) {
				choose=0;
				choose2=1;
				container=ser[choose2];
				ser[choose2]=ser[choose];
				ser[choose]=container;
				}
			rando=rand.nextInt(25)+5;
			for(i=0;i<=rando;i++) {
				choose=2;
				choose2=3;
				container=ser[choose2];
				ser[choose2]=ser[choose];
				ser[choose]=container;
				}
			rando=rand.nextInt(25)+5;
			for(i=0;i<=rando;i++) {
				choose=4;
				choose2=5;
				container=ser[choose2];
				ser[choose2]=ser[choose];
				ser[choose]=container;
				}
			
			rando=rand.nextInt(25)+5;
			for(i=0;i<=rando;i++) {
				choose=6;
				choose2=7;
				container=ser[choose2];
				ser[choose2]=ser[choose];
				ser[choose]=container;
				}
			
			Fser1=ser[0];
			Fser2=ser[1];
			Nser1=ser[2];
			Nser2=ser[3];
			Pser1=ser[4];
			Pser2=ser[5];
			Eser1=ser[6];
			Eser2=ser[7];
			*/
			
			
			
		
		
		
	}//end*/
	public void setScoreTeam() {
		resetBoard();
		Objective o = score.registerNewObjective("Timer", "Bordur");
		o.setDisplaySlot(DisplaySlot.SIDEBAR);
		o.setDisplayName("§4 Wizards UHC");
		Score debut = o.getScore("Score off"+TimerTasks.timeSDay);
		//Score debut2 = o.getScore("voir le temps écoulé");
		Score pvp = o.getScore("   ");
		Score wolf = o.getScore("-Wolf_IV");
		debut.setScore(4);
		//debut2.setScore(3);
		pvp.setScore(2);
		wolf.setScore(1);
		wizN.setScoreboard(score);
		wizP.setScoreboard(score);
		wizF.setScoreboard(score);
		wizE.setScoreboard(score);
		ser1.setScoreboard(score);
		ser2.setScoreboard(score);
		ser3.setScoreboard(score);
		ser4.setScoreboard(score);
		ser5.setScoreboard(score);
		ser6.setScoreboard(score);
		ser7.setScoreboard(score);
		ser8.setScoreboard(score);
		
		
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
		Eteam.addPlayer(wizE);
		Eteam.addPlayer(Eser1);
		Eteam.addPlayer(Eser2);
		Eteam.setAllowFriendlyFire(false);
		
		
	}




	public void resetBoard() {
		for(String s : score.getEntries()) {
			score.resetScores(s);
		}
		
	}
	

}
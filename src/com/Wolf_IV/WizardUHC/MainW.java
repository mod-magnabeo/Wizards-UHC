package com.Wolf_IV.WizardUHC;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import com.Wolf_IV.WizardUHC.Commands.CDayPass;
import com.Wolf_IV.WizardUHC.Commands.CLoud;
import com.Wolf_IV.WizardUHC.Commands.CSpawn;
import com.Wolf_IV.WizardUHC.Commands.CStart;
import com.Wolf_IV.WizardUHC.Commands.CStartHub;
import com.Wolf_IV.WizardUHC.Commands.CStartStop;
import com.Wolf_IV.WizardUHC.Commands.CUhc;
import com.Wolf_IV.WizardUHC.Commands.CWoof;
import com.Wolf_IV.WizardUHC.Role.Wiz;
import com.Wolf_IV.WizardUHC.Role.WizF;
import com.Wolf_IV.WizardUHC.Role.WizN;
import com.Wolf_IV.WizardUHC.Role.WizP;


public class MainW extends JavaPlugin implements Listener {
private Scoreboard s;	
	//public Player wizN= new Player();
	


	@Override
	public void onEnable() {
		saveDefaultConfig();
	System.out.println("Le plugin Wizard UHC est pret a utilisation");
	System.out.println("-Wolf_IV");
	System.out.println("");
	//Command
	CStart cstart= new CStart(this);
	WizN wizN = new WizN(cstart, this);
	WizP wizP = new WizP(cstart, this);
	WizF wizF = new WizF(cstart, this);
	Wiz wiz = new Wiz(cstart, this);
	wizN.recipe();
	wizP.recipe();
	wizF.recipe();
	wiz.recipe();
	getCommand("woof").setExecutor(new CWoof());
	getCommand("loud").setExecutor(new CLoud());
	getCommand("spawn").setExecutor(new CSpawn());
	getCommand("uhc").setExecutor(new CUhc(this));
	getCommand("start").setExecutor(cstart);
	getCommand("startstop").setExecutor(new CStartStop());
	getCommand("starthub").setExecutor(new CStartHub());
	getCommand("daypass").setExecutor(new CDayPass());
	//Command
	getServer().getPluginManager().registerEvents(new WListeners(this, cstart), this);
	getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
	
	s= Bukkit.getScoreboardManager().getMainScoreboard();
	registerHealthBar();
	registerNameTag();
	Bukkit.getPluginManager().registerEvents(this, this);
	}
	
	
	
	@Override
	public void onDisable() {
	System.out.println("-Wolf_IV");
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		s.getTeam("gray").addPlayer(e.getPlayer());
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
		if(s.getObjective("gray") != null) {
			s.getObjective("gray").unregister();
		}
	Team t = s.registerNewTeam("gray");
	t.setPrefix(ChatColor.GRAY+"");
	}
	
	
	
}

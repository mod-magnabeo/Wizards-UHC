package com.Wolf_IV.WizardUHC;


import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import com.Wolf_IV.WizardUHC.Commands.CDayPass;
import com.Wolf_IV.WizardUHC.Commands.CGetPrep;
import com.Wolf_IV.WizardUHC.Commands.CLoud;
import com.Wolf_IV.WizardUHC.Commands.CSpawn;
import com.Wolf_IV.WizardUHC.Commands.CStart;
import com.Wolf_IV.WizardUHC.Commands.CStartHub;
import com.Wolf_IV.WizardUHC.Commands.CStartStop;
import com.Wolf_IV.WizardUHC.Commands.CUhc;
import com.Wolf_IV.WizardUHC.Commands.CWoof;
import com.Wolf_IV.WizardUHC.Role.Wiz;
import com.Wolf_IV.WizardUHC.Role.WizE;
import com.Wolf_IV.WizardUHC.Role.WizF;
import com.Wolf_IV.WizardUHC.Role.WizN;
import com.Wolf_IV.WizardUHC.Role.WizP;


public class MainW extends JavaPlugin implements Listener {

public static boolean ingame;
	//public Player wizN= new Player();
	


	@Override
	public void onEnable() {
		ingame=false;
		 Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "worldborder set 29000000");
		 Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "gamerule naturalRegeneration false");
		 Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "difficulty peaceful");
		saveDefaultConfig();
	System.out.println("Le plugin Wizard UHC est pret a utilisation");
	System.out.println("-Wolf_IV");
	System.out.println("");
	//Command
	CStart cstart= new CStart(this);
	WizN wizN = new WizN(cstart, this);
	WizP wizP = new WizP(cstart, this);
	WizF wizF = new WizF(cstart, this);
	WizE wizE = new WizE(cstart, this);
	Wiz wiz = new Wiz(cstart, this);
	WListeners Lis= new WListeners(this, cstart);
	wizN.recipe();
	wizP.recipe();
	wizF.recipe();
	wizE.recipe();
	wiz.recipe();
	getCommand("woof").setExecutor(new CWoof());
	getCommand("loud").setExecutor(new CLoud());
	getCommand("spawn").setExecutor(new CSpawn());
	getCommand("uhc").setExecutor(new CUhc(this));
	getCommand("startwiz").setExecutor(cstart);
	getCommand("startwizstop").setExecutor(new CStartStop());
	getCommand("starthub").setExecutor(new CStartHub());
	getCommand("daypass").setExecutor(new CDayPass());
	getCommand("getprep").setExecutor(new CGetPrep());
	getCommand("fpvpoff").setExecutor(new CFpvpOff(cstart));
	getCommand("fpvpon").setExecutor(new CFpvpOn(cstart));
	getCommand("revive").setExecutor(new CRevive(cstart));
	getCommand("t").setExecutor(new CTeam(cstart));
	getCommand("effectregister").setExecutor(new CEffect(cstart));
	//Command
	getServer().getPluginManager().registerEvents(new WListeners(this, cstart), this);
	getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
	
	Lis.s= Bukkit.getScoreboardManager().getMainScoreboard();
	Lis.registerHealthBar();
	Lis.registerNameTag();
	Bukkit.getPluginManager().registerEvents(this, this);
	}
	
	
	
	@Override
	public void onDisable() {
	System.out.println("-Wolf_IV");
	}
	
	
	
	
	
}
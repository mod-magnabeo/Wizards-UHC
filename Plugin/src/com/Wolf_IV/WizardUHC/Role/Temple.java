package com.Wolf_IV.WizardUHC.Role;

import java.util.Random;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.Wolf_IV.WizardUHC.MainW;
import com.Wolf_IV.WizardUHC.Commands.CStart;
import com.Wolf_IV.WizardUHC.tasks.TimerFly;
import com.Wolf_IV.WizardUHC.tasks.TimerIncant;

public class Temple {
	private Random rand =new Random();
	private CStart p;
	private MainW main;
	public static boolean EUse;
	public static boolean FUse;
	public static boolean PUse;
	public static boolean NUse;
	public Temple(CStart p, MainW main) {
		this.p =p;
		this.main=main;
		}
	public boolean placeOrBreak(Location bloc) {
		//2000 2000
		for(int x=1950; x<2050; x++) {
			if(x==bloc.getBlockX()) {
			for(int z=1950; z<2050; z++) {
				if(z==bloc.getBlockZ()) {
					return false;
				}
			}
			}
		}
		//2000 -2000
		for(int x=1950; x<2050; x++) {
			if(x==bloc.getBlockX()) {
			for(int z=-1950; z>-2050; z--) {
				if(z==bloc.getBlockZ()) {
					return false;
				}
			}
			}
		}
		//-2000 -2000
		for(int x=-1950; x>-2050; x--) {
			if(x==bloc.getBlockX()) {
			for(int z=-1950; z>-2050; z--) {
				if(z==bloc.getBlockZ()) {
					return false;
				}
			}
			}
		}
		//-2000 2000
		for(int x=-1950; x>-2050; x--) {
			if(x==bloc.getBlockX()) {
			for(int z=1950; z<2050; z++) {
				if(z==bloc.getBlockZ()) {
					return false;
				}
			}
			}
		}
		return true;
		
	}
	public void incant(Player player, Location bloc) {
		
		if(player==p.wizE) {
			for(int x=1950; x<2050; x++) {
				if(x==bloc.getBlockX()) {
				for(int z=1950; z<2050; z++) {
					if(z==bloc.getBlockZ()) {
						if(EUse==false) {
						TimerIncant tasks = new TimerIncant(p, bloc, "E");
						tasks.runTaskTimer(main, 0, 5);
						EUse=true;
					}else {
						player.sendMessage("§4L'incantation est en cours ou bien déja faite");
					}
						
						
						
						
					}
				}
				}
			}
		}
		
		if(player==p.wizF) {
			for(int x=-1950; x>-2050; x--) {
				if(x==bloc.getBlockX()) {
				for(int z=1950; z<2050; z++) {
					if(z==bloc.getBlockZ()) {
						if(FUse==false) {
						TimerIncant tasks = new TimerIncant(p, bloc, "F");
						tasks.runTaskTimer(main, 0, 5);
						FUse=true;
					}else {
						player.sendMessage("§4L'incantation est en cours ou bien déja faite");
					}
						
						
						
						
					}
				}
				}
			}
		}
		
		
		
		if(player==p.wizP) {
			for(int x=1950; x<2050; x++) {
				if(x==bloc.getBlockX()) {
				for(int z=-1950; z>-2050; z--) {
					if(z==bloc.getBlockZ()) {
						if(PUse==false) {
						TimerIncant tasks = new TimerIncant(p, bloc, "P");
						tasks.runTaskTimer(main, 0, 5);
						PUse=true;
					}else {
						player.sendMessage("§4L'incantation est en cours ou bien déja faite");
					}
						
						
						
						
					}
				}
				}
			}
		}
		
		
		if(player==p.wizN) {
			for(int x=-1950; x>-2050; x--) {
				if(x==bloc.getBlockX()) {
				for(int z=-1950; z>-2050; z--) {
					if(z==bloc.getBlockZ()) {
						if(NUse==false) {
						TimerIncant tasks = new TimerIncant(p, bloc, "N");
						tasks.runTaskTimer(main, 0, 5);
						NUse=true;
					}else {
						player.sendMessage("§4L'incantation est en cours ou bien déja faite");
					}
						
						
						
						
					}
				}
				}
			}
		}
		
		
		
		
		
	}
	

}

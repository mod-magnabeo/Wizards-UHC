package com.Wolf_IV.WizardUHC.tasks;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.Wolf_IV.WizardUHC.MainW;
import com.Wolf_IV.WizardUHC.Commands.CStart;

public class TimerIncant extends BukkitRunnable {
	private Player player=null;
	private CStart p;
	private MainW main;
	private Location bloc;
	private String type;
	private Random rand =new Random();
	private int timer= -21;
	public TimerIncant(CStart cStart, Location blocK, String team) {
		this.p= cStart;
		this.bloc = blocK;
		this.type =team;
	}
	@Override
	public void run() {
		
		
					/**
					 * Pour prochaine fois mettre if pour E faire timer random et paeticule en attendent en prenent en compte 
					 * que quart de seconde faire sons si possible
					 */
		if(timer==-21) {
			if(type.equalsIgnoreCase("E")) {
				player=p.wizE;
			}else if(type.equalsIgnoreCase("F")) {
				player=p.wizF;
			}else if(type.equalsIgnoreCase("P")) {
				player=p.wizP;
			}else if(type.equalsIgnoreCase("N")) {
				player=p.wizN;
			}
			timer=rand.nextInt(600);
			if(timer<200) {
				timer=timer+rand.nextInt(200);
			}
			if(timer>400) {
				timer=timer-rand.nextInt(200);
			}
		}
			
			if(timer>0) {
				timer--;
				Location par=new Location(bloc.getWorld(),bloc.getBlockX()+0.5,bloc.getBlockY()+1,bloc.getBlockZ()+0.5);
				player.playEffect(par, Effect.EXTINGUISH, 20);
				player.playEffect(par, Effect.COLOURED_DUST, 20);
				player.playEffect(par, Effect.SLIME, 20);
				par=new Location(bloc.getWorld(),bloc.getBlockX()+0.5,bloc.getBlockY()+2,bloc.getBlockZ()+0.5);
				player.playEffect(par, Effect.WATERDRIP, 20);
				par=new Location(bloc.getWorld(),bloc.getBlockX()+0.5,bloc.getBlockY()-0.5,bloc.getBlockZ()+0.5);
				player.playEffect(par, Effect.MOBSPAWNER_FLAMES, 20);
				par=new Location(bloc.getWorld(),bloc.getBlockX()+0.2,bloc.getBlockY()+1,bloc.getBlockZ()+0.2);
				player.playEffect(par, Effect.VOID_FOG, 20);
				par=new Location(bloc.getWorld(),bloc.getBlockX()+1,bloc.getBlockY()+1,bloc.getBlockZ()+0.2);
				player.playEffect(par, Effect.VOID_FOG, 20);
				par=new Location(bloc.getWorld(),bloc.getBlockX()+1,bloc.getBlockY()+1,bloc.getBlockZ()+1);
				player.playEffect(par, Effect.VOID_FOG, 20);
				par=new Location(bloc.getWorld(),bloc.getBlockX()+0.2,bloc.getBlockY()+1,bloc.getBlockZ()+1);
				player.playEffect(par, Effect.VOID_FOG, 20);
			}else {
				
				for(int i=0; i<1000; i++) {
					double xp=rand.nextDouble()*6-3;
					double yp=rand.nextDouble()*8-4;
					double zp=rand.nextDouble()*6-3;
					Location part =new Location(bloc.getWorld(),bloc.getBlockX()+xp,bloc.getBlockY()+yp,bloc.getBlockZ()+zp);
					player.playEffect(part, Effect.COLOURED_DUST, 20);
					player.playEffect(part, Effect.FIREWORKS_SPARK, 20);
					player.playEffect(part, Effect.GHAST_SHRIEK, 20);
					}
			
			if(type.equalsIgnoreCase("E")) {
					Location tp=new Location(bloc.getWorld(),bloc.getBlockX()+0.5,bloc.getBlockY()+2,bloc.getBlockZ()+0.5);
					p.Eser1.teleport(tp);
					p.Eser2.teleport(tp);
					cancel();
			}else if(type.equalsIgnoreCase("F")) {
				Location tp=new Location(bloc.getWorld(),bloc.getBlockX()+0.5,bloc.getBlockY()+2,bloc.getBlockZ()+0.5);
				p.Fser1.teleport(tp);
				p.Fser2.teleport(tp);
				cancel();
		}else if(type.equalsIgnoreCase("P")) {
			Location tp=new Location(bloc.getWorld(),bloc.getBlockX()+0.5,bloc.getBlockY()+2,bloc.getBlockZ()+0.5);
			p.Pser1.teleport(tp);
			p.Pser2.teleport(tp);
			cancel();
	}else if(type.equalsIgnoreCase("N")) {
		Location tp=new Location(bloc.getWorld(),bloc.getBlockX()+0.5,bloc.getBlockY()+2,bloc.getBlockZ()+0.5);
		p.Nser1.teleport(tp);
		p.Nser2.teleport(tp);
		cancel();
} 
			
			
			}
					
				
				

	}

}

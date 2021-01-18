package com.Wolf_IV.WizardUHC.tasks;

import org.bukkit.scheduler.BukkitRunnable;

public class TimerProt extends BukkitRunnable {

	public static int timerFallA=0;
	public static boolean NoHurtA=false;
	public static int timerFallP=0;
	public static boolean NoHurtP=false;
	public static int timerFallF=0;
	public static boolean NoHurtF=false;
	public static int timerFallN=0;
	public static boolean NoHurtN=false;
	public static int timerFallE=0;
	public static boolean NoHurtE=false;
	private boolean cancel=false;
	
	@Override
	public void run() {
		
		if(cancel==true) {
			cancel=false;
			cancel();
		}
		
		
		if(timerFallA>0) {
			timerFallA--;
			NoHurtA=true;
			if(timerFallA==0) cancel=true;
		}else {
			NoHurtA=false;
		}
		if(timerFallP>0) {
			timerFallP--;
			NoHurtP=true;
			if(timerFallP==0) cancel=true;
		}else {
			NoHurtP=false;
		}
		if(timerFallF>0) {
			timerFallF--;
			NoHurtF=true;
			if(timerFallF==0) cancel=true;
		}else {
			NoHurtF=false;
		}
		if(timerFallN>0) {
			timerFallN--;
			NoHurtN=true;
			if(timerFallN==0) cancel=true;
		}else {
			NoHurtN=false;
		}
		if(timerFallE>0) {
			timerFallE--;
			NoHurtE=true;
			if(timerFallE==0) cancel=true;
		}else {
			NoHurtE=false;
		}

	}

}

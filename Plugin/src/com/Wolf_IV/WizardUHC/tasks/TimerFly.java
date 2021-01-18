package com.Wolf_IV.WizardUHC.tasks;

import org.bukkit.scheduler.BukkitRunnable;

import com.Wolf_IV.WizardUHC.Commands.CStart;

public class TimerFly extends BukkitRunnable {
	public static int timer=5;
	public static boolean enCours=false;
	private CStart p;
	public TimerFly(CStart cStart) {
		this.p= cStart;
	}
	@Override
	public void run() {
		enCours=true;
		p.wizE.sendMessage("§3Il te reste §e"+timer+"s §3de vol");
		timer--;
		if(timer==-1) {
			p.wizE.setAllowFlight(false);
            p.wizE.setFlying(false);
            cancel();
            enCours=false;
		}

	}

}

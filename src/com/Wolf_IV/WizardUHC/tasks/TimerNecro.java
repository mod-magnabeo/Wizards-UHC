package com.Wolf_IV.WizardUHC.tasks;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.scheduler.BukkitRunnable;

import com.Wolf_IV.WizardUHC.MainW;
import com.Wolf_IV.WizardUHC.Commands.CStart;
import com.Wolf_IV.WizardUHC.Role.WizN;

public class TimerNecro extends BukkitRunnable {

	private CStart p;
	public TimerNecro(CStart cStart) {
		this.p= cStart;
	}

	@Override
	public void run() {
		if(WizN.teleportEnd>0) {
			WizN.teleportEnd--;
			if(WizN.teleportEnd==0) {
				WizN.teleportEnd=-1;
				Location end =new Location(Bukkit.getWorld("worldSpawn_the_end"), 200, 79, 0);
				end.getBlock().setType(Material.OBSIDIAN);
				end =new Location(Bukkit.getWorld("worldSpawn_the_end"), 200, 79, 1);
				end.getBlock().setType(Material.OBSIDIAN);
				end =new Location(Bukkit.getWorld("worldSpawn_the_end"), 200, 79, -1);
				end.getBlock().setType(Material.OBSIDIAN);
				end =new Location(Bukkit.getWorld("worldSpawn_the_end"), 199, 79, 0);
				end.getBlock().setType(Material.OBSIDIAN);
				end =new Location(Bukkit.getWorld("worldSpawn_the_end"), 201, 79, 0);
				end.getBlock().setType(Material.OBSIDIAN);
				end =new Location(Bukkit.getWorld("worldSpawn_the_end"), 200, 80, 1);
				p.wizN.teleport(end);
				end =new Location(Bukkit.getWorld("worldSpawn_the_end"), 201, 80, 0);
				p.Nser1.teleport(end);
			}else {
				p.wizN.sendMessage("§5§oTeleportation a l'end dans "+WizN.teleportEnd+"s "+"§2§lSNEAK ET REGARD VERS LE BAS");
				p.Nser1.sendMessage("§5§oTeleportation a l'end dans "+WizN.teleportEnd+"s "+"§2§lSNEAK ET REGARD VERS LE BAS");
			}
		}

	}

}

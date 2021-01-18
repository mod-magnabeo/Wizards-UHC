package com.Wolf_IV.WizardUHC;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.Wolf_IV.WizardUHC.Commands.CStart;

public class CRevive implements CommandExecutor {

	private CStart p;
	public CRevive(CStart p) {
		this.p=p;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] arg3) {
		if(sender instanceof Player) {
			if(cmd.getName().equalsIgnoreCase("revive")) {
			Player player = (Player)sender;
			Bukkit.broadcastMessage(player.getName()+" C'est revive de lui meme grace a une commande");
			player.setGameMode(GameMode.SURVIVAL);
			p.wizF.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 0, true));
			p.wizF.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999, 0, true));
			p.wizN.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999, 1, true));
			p.wizN.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 999999, 0, true));
			p.wizP.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 999999, 1, true));
			p.wizP.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 999999, 1, true));
			p.wizE.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 999999, 0, true));
			p.Fser1.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 0, true));
			p.Fser1.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999, 0, true));
			p.Nser1.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999, 1, true));
			p.Nser1.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 999999, 0, true));
			p.Pser1.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 999999, 1, true));
			p.Pser1.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 999999, 1, true));
			p.Eser1.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 999999, 0, true));
			p.Fser2.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 0, true));
			p.Fser2.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999, 0, true));
			p.Nser2.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999, 1, true));
			p.Nser2.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 999999, 0, true));
			p.Pser2.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 999999, 1, true));
			p.Pser2.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 999999, 1, true));
			p.Eser2.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 999999, 0, true));
			
			if(p.Fser1 ==player) {
				p.Fser1D=false;
			}else if(p.Fser2 ==player) {
				p.Fser2D=false;
			}else if(p.Nser1 ==player) {
				p.Nser1D=false;
			}else if(p.Nser2 ==player) {
				p.Nser2D=false;
			}else if(p.Eser1 ==player) {
				p.Eser1D=false;
			}else if(p.Eser2 ==player) {
				p.Eser2D=false;
			}else if(p.Pser1 ==player) {
				p.Pser1D=false;
				p.Pser1.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 20, 100, true));
			}else if(p.Pser2 ==player) {
				p.Pser2D=false;
				p.Pser2.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 20, 200, true));
			}else if(p.wizP ==player) {
				p.wizP.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 20, 200, true));
			}
			
			
			return true;
			}
		}
		return false;
	}

}

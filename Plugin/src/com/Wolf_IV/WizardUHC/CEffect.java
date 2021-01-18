package com.Wolf_IV.WizardUHC;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.Wolf_IV.WizardUHC.Commands.CStart;

public class CEffect implements CommandExecutor {
	private CStart p;
	public CEffect(CStart p) {
		this.p=p;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player)sender;
			if(cmd.getName().equalsIgnoreCase("effectregister")) {
				
				p.wizF.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 0, true));
				p.wizF.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999, 0, true));
				p.wizN.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999, 1, true));
				p.wizN.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 999999, 0, true));
				p.wizP.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 999999, 1, true));
				p.wizP.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 20, 100, true));
				p.wizP.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 999999, 1, true));
				p.Fser1.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 0, true));
				p.Fser1.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999, 0, true));
				p.Nser1.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999, 1, true));
				p.Nser1.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 999999, 0, true));
				p.Pser1.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 999999, 1, true));
				p.Pser1.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 20, 100, true));
				p.Pser1.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 999999, 1, true));
				p.Fser2.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 0, true));
				p.Fser2.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999, 0, true));
				p.Nser2.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999, 1, true));
				p.Nser2.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 999999, 0, true));
				p.Pser2.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 999999, 1, true));
				p.Pser2.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 20, 200, true));
				p.Pser2.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 999999, 1, true));
				
				return true;
			}
			}
		return false;
	}

}

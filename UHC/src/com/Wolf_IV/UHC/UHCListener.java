package com.Wolf_IV.UHC;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import com.Wolf_IV.UHC.Commands.CStart;

public class UHCListener implements Listener {
	
	//DyeColor.BROWN
	//DyeColor.CYAN
	//DyeColor.LIGHT_BLUE
	//DyeColor.LIME
	//DyeColor.PINK
	//DyeColor.ORANGE
	public static Player TB1= null;
	public static Player TB2= null;
	public static Player TV1= null;
	public static Player TV2= null;
	public static Player TM1= null;
	public static Player TM2= null;
	public static Player TN1= null;
	public static Player TN2= null;
	public static Player TJ1= null;
	public static Player TJ2= null;
	public static Player TR1= null;
	public static Player TR2= null;
	public static Player TC1= null;
	public static Player TC2= null;
	public static Player TL1= null;
	public static Player TL2= null;
	public static Player TI1= null;
	public static Player TI2= null;
	public static Player TP1= null;
	public static Player TP2= null;
	public static Player TO1= null;
	public static Player TO2= null;
	@EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
		 if (event.getEntity() instanceof Player) {
             Player victim = (Player)event.getEntity();
            if(TimerProt.NoHurtA==true) {
                event.setCancelled(true);
            }
		 }
	}
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		Player player =event.getPlayer();
		Action action =event.getAction();
		ItemStack it =event.getItem();
		if(it != null) {
			if(it.hasItemMeta() && it.getItemMeta().hasDisplayName()) {
				if(it.getItemMeta().getDisplayName().equalsIgnoreCase(CStart.Nvert) || it.getItemMeta().getDisplayName().equalsIgnoreCase(CStart.Nnoir) || it.getItemMeta().getDisplayName().equalsIgnoreCase(CStart.Nmagenta) || it.getItemMeta().getDisplayName().equalsIgnoreCase(CStart.Njaune) || it.getItemMeta().getDisplayName().equalsIgnoreCase(CStart.Nbleu) || it.getItemMeta().getDisplayName().equalsIgnoreCase(CStart.Nbrown) || it.getItemMeta().getDisplayName().equalsIgnoreCase(CStart.Ncyan) || it.getItemMeta().getDisplayName().equalsIgnoreCase(CStart.NbleuClair) || it.getItemMeta().getDisplayName().equalsIgnoreCase(CStart.Nlime) || it.getItemMeta().getDisplayName().equalsIgnoreCase(CStart.Npink) || it.getItemMeta().getDisplayName().equalsIgnoreCase(CStart.Norange)) {
					if(TB1==player) {
						TB1= null;
					}
					if(TB2==player) {
						TB2= null;
					}
					if(TJ1==player) {
						TJ1= null;
					}
					if(TJ2==player) {
						TJ2= null;
					}
					if(TN1==player) {
						TN1= null;
					}
					if(TN2==player) {
						TN2= null;
					}
					if(TV1==player) {
						TV1= null;
					}
					if(TV2==player) {
						TV2= null;
					}
					if(TM1==player) {
						TM1= null;
					}
					if(TM2==player) {
						TM2= null;
					}
					if(TR1==player) {
						TR1= null;
					}
					if(TR2==player) {
						TR2= null;
					}
					if(TC1==player) {
						TC1= null;
					}
					if(TC2==player) {
						TC2= null;
					}
					if(TL1==player) {
						TL1= null;
					}
					if(TL2==player) {
						TL2= null;
					}
					if(TI1==player) {
						TI1= null;
					}
					if(TI2==player) {
						TI2= null;
					}
					if(TP1==player) {
						TP1= null;
					}
					if(TP2==player) {
						TP2= null;
					}
					if(TO1==player) {
						TO1= null;
					}
					if(TO2==player) {
						TO2= null;
					}
				}
			}
	if(it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(CStart.Nbleu)) {
		if(TB1==null) {
			TB1=player;
			Bukkit.broadcastMessage("§1"+player.getName()+" A rejoin l'équipe bleu");
		}else if(TB2==null) {
			TB2=player;
			Bukkit.broadcastMessage("§1"+player.getName()+" A rejoin l'équipe bleu");
		}else {
			player.sendMessage("§4Il n'y a plus de place dans cette équipe");
		}
	}
	if(it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(CStart.Njaune)) {
		if(TJ1==null) {
			TJ1=player;
			Bukkit.broadcastMessage("§e"+player.getName()+" A rejoin l'équipe jaune");
		}else if(TJ2==null) {
			TJ2=player;
			Bukkit.broadcastMessage("§e"+player.getName()+" A rejoin l'équipe jaune");
		}else {
			player.sendMessage("§4Il n'y a plus de place dans cette équipe");
		}
	}
	if(it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(CStart.Nmagenta)) {
		if(TM1==null) {
			TM1=player;
			Bukkit.broadcastMessage("§5"+player.getName()+" A rejoin l'équipe magenta");
		}else if(TM2==null) {
			TM2=player;
			Bukkit.broadcastMessage("§5"+player.getName()+" A rejoin l'équipe magenta");
		}else {
			player.sendMessage("§4Il n'y a plus de place dans cette équipe");
		}
	}
	if(it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(CStart.Nnoir)) {
		if(TN1==null) {
			TN1=player;
			Bukkit.broadcastMessage("§0"+player.getName()+" A rejoin l'équipe noir");
		}else if(TN2==null) {
			TN2=player;
			Bukkit.broadcastMessage("§0"+player.getName()+" A rejoin l'équipe noir");
		}else {
			player.sendMessage("§4Il n'y a plus de place dans cette équipe");
		}
	}
	if(it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(CStart.Nvert)) {
		if(TV1==null) {
			TV1=player;
			Bukkit.broadcastMessage("§2"+player.getName()+" A rejoin l'équipe vert");
		}else if(TV2==null) {
			TV2=player;
			Bukkit.broadcastMessage("§2"+player.getName()+" A rejoin l'équipe vert");
		}else {
			player.sendMessage("§4Il n'y a plus de place dans cette équipe");
		}
	}
	
	if(it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(CStart.Nbrown)) {
		if(TR1==null) {
			TR1=player;
			Bukkit.broadcastMessage("§0"+player.getName()+" A rejoin l'équipe Marron");
		}else if(TR2==null) {
			TR2=player;
			Bukkit.broadcastMessage("§0"+player.getName()+" A rejoin l'équipe Marron");
		}else {
			player.sendMessage("§4Il n'y a plus de place dans cette équipe");
		}
	}
	
	if(it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(CStart.Ncyan)) {
		if(TC1==null) {
			TC1=player;
			Bukkit.broadcastMessage("§b"+player.getName()+" A rejoin l'équipe Cyan");
		}else if(TC2==null) {
			TC2=player;
			Bukkit.broadcastMessage("§b"+player.getName()+" A rejoin l'équipe Cyan");
		}else {
			player.sendMessage("§4Il n'y a plus de place dans cette équipe");
		}
	}
	
	if(it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(CStart.NbleuClair)) {
		if(TL1==null) {
			TL1=player;
			Bukkit.broadcastMessage("§b"+player.getName()+" A rejoin l'équipe Bleu Clair");
		}else if(TL2==null) {
			TL2=player;
			Bukkit.broadcastMessage("§b"+player.getName()+" A rejoin l'équipe Bleu Clair");
		}else {
			player.sendMessage("§4Il n'y a plus de place dans cette équipe");
		}
	}
	
	if(it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(CStart.Nlime)) {
		if(TI1==null) {
			TI1=player;
			Bukkit.broadcastMessage("§a"+player.getName()+" A rejoin l'équipe Vert Clair");
		}else if(TI2==null) {
			TI2=player;
			Bukkit.broadcastMessage("§a"+player.getName()+" A rejoin l'équipe Vert Clair");
		}else {
			player.sendMessage("§4Il n'y a plus de place dans cette équipe");
		}
	}
	
	if(it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(CStart.Npink)) {
		if(TP1==null) {
			TP1=player;
			Bukkit.broadcastMessage("§d"+player.getName()+" A rejoin l'équipe Rose");
		}else if(TP2==null) {
			TP2=player;
			Bukkit.broadcastMessage("§d"+player.getName()+" A rejoin l'équipe Rose");
		}else {
			player.sendMessage("§4Il n'y a plus de place dans cette équipe");
		}
	}
	
	if(it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(CStart.Norange)) {
		if(TO1==null) {
			TO1=player;
			Bukkit.broadcastMessage("§6"+player.getName()+" A rejoin l'équipe Orange");
		}else if(TO2==null) {
			TO2=player;
			Bukkit.broadcastMessage("§6"+player.getName()+" A rejoin l'équipe Orange");
		}else {
			player.sendMessage("§4Il n'y a plus de place dans cette équipe");
		}
	}
	
	
	}
	}
}

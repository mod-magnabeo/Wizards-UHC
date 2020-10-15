package com.Wolf_IV.MagmaCoin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import com.Wolf_IV.MagmaCoin.command.CStartCount;



public class MListeners implements Listener {
	int i;
	int i2;
	int i3;
	private CStartCount p;
	public MListeners(CStartCount p) {
	this.p = p;
	}
	
	@SuppressWarnings("static-access")
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		for(i = 1; i<=p.nubPlayer; i++) {
			if(player == Bukkit.getPlayer(p.playersName[i])) {
				p.players[i]=player;
			}
		}
	}
	
	
	@SuppressWarnings("static-access")
	@EventHandler
    public void onTestEntityDamage(EntityDamageByEntityEvent event) {
		if(p.ingame != true) {
			return;
		}
	
		if (!(event.getDamager() instanceof Player)){
            if (!(event.getEntity() instanceof Player)) {
            	return;
            }
		}
	
            	 Player victim = (Player)event.getEntity();
            	 Player Damager = (Player)event.getDamager();
            	 for(i = 1; i<=p.nubPlayer; i++) {
         			if(victim == p.players[i]) {
         				p.playerHit[i]=Damager;
         				
         			
            	 
		}
	}
            	
	
}
	
	@SuppressWarnings("static-access")
	@EventHandler
	  public void onEntityDeath(EntityDeathEvent event) {
		
		if (!(event.getEntity() instanceof Player)) {
		      return;
		    }
		      Player victim = (Player)event.getEntity();
		      for(i = 1; i<=p.nubPlayer; i++) {
       			if(victim == p.players[i]) {
       				if(p.playerAlive[i] == false) {
       					return;
       				}else {
       					p.playerAlive[i]=false;
       				}
       				p.players[i].sendMessage("§aVous etes mort avec un total de "+p.playerP[i]+" points");
       			 for(i3 = 1; i3<=p.nubPlayer; i3++) {
       				 if(p.playerAlive[i3] == true) {
       					p.players[i3].sendMessage("§a"+victim.getName()+" est mort. Vous recever "+p.surviveP+" points");
       					p.playerP[i3]=p.playerP[i3] + p.surviveP;
       				 }
       			 }
       				
       				if(p.playerHit[i] ==null) {
       					return;
       				}
       				p.playerHit[i].sendMessage("§aVous recever "+p.killP+" points pour avoir tuer "+victim.getName());
       			 for(int i2 = 1; i2<=p.nubPlayer; i2++) {
       				 if(p.playerHit[i] == p.players[i2]) {
       					 p.playerP[i2]=p.playerP[i2] + p.killP;
       					p.playerS[i2]=p.playerS[i2] + p.killS;
       				 }
       				 }
       			
       			}}
		  
	}
	
	
	
	

	
}
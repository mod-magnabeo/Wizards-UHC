package com.Wolf_IV.WizardUHC.tasks;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class LittleThings {

	public static void setBlock(Entity enferm�, Material Block, int x, int y, int z) {
		if(enferm� != null) {
		Location ploc = enferm�.getLocation();
		Location block =new Location(enferm�.getWorld(),ploc.getBlockX()+x, ploc.getY()+y,ploc.getZ()+z);
		block.getBlock().setType(Block);
		}else {
			Location block =new Location(Bukkit.getWorld("worldSpawn"),x, y,z);
			block.getBlock().setType(Block);
		}
	}
}

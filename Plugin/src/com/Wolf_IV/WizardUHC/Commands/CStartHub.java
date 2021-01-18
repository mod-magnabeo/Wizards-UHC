package com.Wolf_IV.WizardUHC.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CStartHub implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(sender instanceof Player) {
			if(cmd.getName().equalsIgnoreCase("starthub")) {
			Player player = (Player)sender;
			Location block =new Location(Bukkit.getWorld("worldSpawn"), 0, 120, 0);
			for(int ix=-100; ix<100; ix++) {
				for(int iz=-100; iz<100; iz++) {
				block = new Location(Bukkit.getWorld("worldSpawn"), ix, 120, iz);
				block.getBlock().setType(Material.STAINED_GLASS);
				}
			}
			return true;
			}
		}
		return false;
	}

}

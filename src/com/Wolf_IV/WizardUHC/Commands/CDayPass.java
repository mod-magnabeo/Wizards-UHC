package com.Wolf_IV.WizardUHC.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Wolf_IV.WizardUHC.tasks.TimerTasks;

public class CDayPass implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if(sender instanceof Player) {
			Player player = (Player)sender;
			if(cmd.getName().equalsIgnoreCase("daypass")) {
				
				if(args.length==0) {
					player.sendMessage("�4ERROR�b La commande est �a/daypass <jour>");
				}
				
				if(args.length==1) {
					//int argsNum = Integer.parseInt(args[1]);
					//int jour=0;
					//for(int i=1;i<30;) {
						//if(argsNum==i) {
							//jour=i;
							//i=50;
						//}
					//	i++;
					//}
					TimerTasks.timeSDay=2698;
					//TimerTasks.timeDay=jour-1;
					
				}
			return true;
			}
			
			}
		return false;
	}

}
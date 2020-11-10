package com.Wolf_IV.UHC.Commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.Wolf_IV.UHC.MainUHC;
import com.Wolf_IV.UHC.TimerTasks;

public class CStart implements CommandExecutor {
	public static String Nvert="§2Rejoindre Equipe Verte";
	public static String Njaune="§eRejoindre Equipe Jaune";
	public static String Nbleu="§1Rejoindre Equipe Blue";
	public static String Nnoir="§0Rejoindre Equipe Noir";
	public static String Nmagenta="§5Rejoindre Equipe Magenta";
	public static String Nbrown="§0Rejoindre Equipe Marron";
	public static String Ncyan="§bRejoindre Equipe Cyan";
	public static String NbleuClair="§bRejoindre Equipe Bleu Clair";
	public static String Nlime="§aRejoindre Equipe Vert Clair";
	public static String Npink="§dRejoindre Equipe Rose";
	public static String Norange="§6Rejoindre Equipe Orange";
	private static MainUHC main;
	public CStart(MainUHC mainUHC) { 
		this.main= mainUHC;
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		
		if(sender instanceof Player) {
			if(cmd.getName().equalsIgnoreCase("startuhc")) {
				Player player = (Player) sender;
				TimerTasks tasks = new TimerTasks(main);
				tasks.runTaskTimer(main, 0, 20);
				TimerTasks.starting=true;
				for (Player playerO : Bukkit.getServer().getOnlinePlayers()) {
					playerO.getInventory().clear();
					//bleu/jaune noir/blanc vert/magenta 
					//DyeColor.BROWN
					//DyeColor.CYAN
					//DyeColor.LIGHT_BLUE
					//DyeColor.LIME
					//DyeColor.PINK
					//DyeColor.ORANGE
					playerO.getInventory().setHeldItemSlot(0);
					 ItemStack Green = new ItemStack(Material.INK_SACK, 1, (short)0, DyeColor.MAGENTA.getData());
					ItemMeta customG = Green.getItemMeta();
					customG.setDisplayName(Nvert);
					Green.setItemMeta(customG);
					playerO.getInventory().setItemInHand(Green);
					
					playerO.getInventory().setHeldItemSlot(1);
					 Green = new ItemStack(Material.INK_SACK, 1, (short)0, DyeColor.BLUE.getData());
					 customG = Green.getItemMeta();
					customG.setDisplayName(Njaune);
					Green.setItemMeta(customG);
					playerO.getInventory().setItemInHand(Green);
					
					playerO.getInventory().setHeldItemSlot(2);
					 Green = new ItemStack(Material.INK_SACK, 1, (short)0, DyeColor.YELLOW.getData());
					 customG = Green.getItemMeta();
					customG.setDisplayName(Nbleu);
					Green.setItemMeta(customG);
					playerO.getInventory().setItemInHand(Green);
					
					playerO.getInventory().setHeldItemSlot(3);
					 Green = new ItemStack(Material.INK_SACK, 1, (short)0, DyeColor.WHITE.getData());
					 customG = Green.getItemMeta();
					customG.setDisplayName(Nnoir);
					Green.setItemMeta(customG);
					playerO.getInventory().setItemInHand(Green);
					
					playerO.getInventory().setHeldItemSlot(4);
					 Green = new ItemStack(Material.INK_SACK, 1, (short)0, DyeColor.GREEN.getData());
					 customG = Green.getItemMeta();
					customG.setDisplayName(Nmagenta);
					Green.setItemMeta(customG);
					playerO.getInventory().setItemInHand(Green);
					
					playerO.getInventory().setHeldItemSlot(5);
					 Green = new ItemStack(Material.INK_SACK, 1, (short)0, DyeColor.LIGHT_BLUE.getData());
					 customG = Green.getItemMeta();
					customG.setDisplayName(Nbrown);
					Green.setItemMeta(customG);
					playerO.getInventory().setItemInHand(Green);
					
					playerO.getInventory().setHeldItemSlot(6);
					 Green = new ItemStack(Material.INK_SACK, 1, (short)0, DyeColor.PINK.getData());
					 customG = Green.getItemMeta();
					customG.setDisplayName(Ncyan);
					Green.setItemMeta(customG);
					playerO.getInventory().setItemInHand(Green);
					
					playerO.getInventory().setHeldItemSlot(7);
					 Green = new ItemStack(Material.INK_SACK, 1, (short)0, DyeColor.BROWN.getData());
					 customG = Green.getItemMeta();
					customG.setDisplayName(NbleuClair);
					Green.setItemMeta(customG);
					playerO.getInventory().setItemInHand(Green);
					
					
					playerO.getInventory().setHeldItemSlot(8);
					 Green = new ItemStack(Material.INK_SACK, 1, (short)0, DyeColor.PURPLE.getData());
					 customG = Green.getItemMeta();
					customG.setDisplayName(Nlime);
					Green.setItemMeta(customG);
					playerO.getInventory().setItemInHand(Green);
					
					
					
					 Green = new ItemStack(Material.INK_SACK, 1, (short)0, DyeColor.CYAN.getData());
					 customG = Green.getItemMeta();
					customG.setDisplayName(Npink);
					Green.setItemMeta(customG);
					playerO.getInventory().addItem(Green);
					
					
					Green = new ItemStack(Material.INK_SACK, 1, (short)0, DyeColor.RED.getData());
					 customG = Green.getItemMeta();
					customG.setDisplayName(Norange);
					Green.setItemMeta(customG);
					playerO.getInventory().addItem(Green);
					
					
					}
				
				
			}
		}
		return false;
	}

}

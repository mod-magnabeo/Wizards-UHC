package com.Wolf_IV.WizardUHC;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import com.Wolf_IV.WizardUHC.Commands.CStart;
import com.Wolf_IV.WizardUHC.tasks.TimerTasks;

public class CFpvpOff implements CommandExecutor {
	private CStart p;
	public CFpvpOff(CStart p) {
		this.p=p;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] arg3) {
		p.resetBoard();
		ScoreboardManager scoreM = Bukkit.getScoreboardManager();
			Scoreboard score = scoreM.getNewScoreboard();
			Objective o = score.registerNewObjective("Debut", "Pvp");
			o.setDisplaySlot(DisplaySlot.SIDEBAR);
			o.setDisplayName("§4 Wizards UHC");
			Score debut = o.getScore("Temps:"+TimerTasks.timeSDay);
			//Score debut2 = o.getScore("voir le temps écoulrré");
			Score pvp = o.getScore("Pvp Jour 4 kqwknkx");
			Score wolf = o.getScore("-Wolf_IV");
			debut.setScore(4);
			//debut2.setScore(3);
			pvp.setScore(2);
			wolf.setScore(1);
			p.wizF.setScoreboard(score);
		if(sender instanceof Player) {
			if(cmd.getName().equalsIgnoreCase("fpvpoff")) {
			Player player = (Player)sender;
			CStart.fpvp=false;
			Bukkit.broadcastMessage("§aLe freindly fire et le pvp est activer");
			p.Fteam.setAllowFriendlyFire(true);
			p.Pteam.setAllowFriendlyFire(true);
			p.Nteam.setAllowFriendlyFire(true);
			
			
			return true;
			}
		}
		return false;
	}

}

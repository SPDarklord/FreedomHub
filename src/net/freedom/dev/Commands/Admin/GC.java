package net.freedom.dev.Commands.Admin;

import java.lang.management.ManagementFactory;

import net.freedom.dev.Utils.Chat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GC implements CommandExecutor {

	public boolean onCommand(CommandSender cs, Command cmd, String tag, String[] args) {



		Player player = (Player)cs;


		if (player.hasPermission("net.admin")) {			
			Chat.sendMessage(cs, "Uptime: " + Chat.formatDateDiff(ManagementFactory.getRuntimeMXBean().getStartTime()));
			Chat.sendMessage(cs, "Max Memory: " + Runtime.getRuntime().maxMemory() / 1024L / 1024L + "MB");
			Chat.sendMessage(cs, "Total Memory: " + Runtime.getRuntime().totalMemory() / 1024L / 1024L + "MB");
			Chat.sendMessage(cs, "Free Memory: " + Runtime.getRuntime().freeMemory() / 1024L / 1024L + "MB");
			player.chat("/tps");
		} else {

			Chat.get();
			Chat.noPerms(player);

		}



		return false;
	}

}

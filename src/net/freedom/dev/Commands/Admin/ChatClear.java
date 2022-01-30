package net.freedom.dev.Commands.Admin;

import net.freedom.dev.Utils.Chat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatClear implements CommandExecutor{

	public boolean onCommand(CommandSender cs, Command cmd, String tag, String[] args) {

		Player player = (Player)cs;
		if(cmd.getName().equalsIgnoreCase("chatclear")) {	
			if (player.hasPermission("net.admin")) {
				for (int i = 0; i < 25; i++) { 
					Bukkit.broadcastMessage(" "); 
				}
				Bukkit.broadcastMessage(Chat.prefix + ChatColor.YELLOW + "The chat has been cleared!");

			}
		}
		return false;
	}
}

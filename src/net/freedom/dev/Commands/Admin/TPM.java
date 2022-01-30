package net.freedom.dev.Commands.Admin;

import net.freedom.dev.Utils.Chat;
import net.freedom.dev.Utils.Lists;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TPM implements CommandExecutor{


	public boolean onCommand(CommandSender cs, Command cmd, String tag, String[] args) {

		Player player = (Player)cs;
		if(cs instanceof Player) {
			if(cmd.getName().equalsIgnoreCase("playermessages")) {
				if (player.hasPermission("net.admin")) {
					if(Lists.get().Join.contains(player.getName())){
						Lists.get().Join.remove(player.getName());
						Chat.sendMessage(player, "You will now no longer see player join and leave messages!");
						Chat.sendMessage(player, "To turn them on type /playermessages");
					}else{
						Lists.get().Join.add(player.getName());
						Chat.sendMessage(player, "You will now see player join and leave messages!");
						Chat.sendMessage(player, "To turn them off type /playermessages");
					}
				}
			}
		}
		return false;
	}
}

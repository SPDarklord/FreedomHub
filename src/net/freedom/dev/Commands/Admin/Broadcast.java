package net.freedom.dev.Commands.Admin;

import net.freedom.dev.Utils.Chat;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Broadcast implements CommandExecutor {


	public boolean onCommand(CommandSender cs, Command cmd, String tag, String[] message) {


			Player player = (Player)cs;
			if (player.hasPermission("hub.admin")) {
				if(cmd.getName().equalsIgnoreCase("broadcast")){
					if (message.length > 0) {	    	
						StringBuilder builder = new StringBuilder();

						for (int i = 0; i < message.length; i++) {
						    builder.append(message[i]).append(" ");
						}

						String text = builder.toString().trim();
						Chat.bc(text);
					}else{				
						Chat.sendMessage(player, "Usage:");
						Chat.sendMessage(player, "/" + tag + " message");
					}
				}
			} else {
				Chat.noPerms(player);
			}
		
		return false;
	}


}
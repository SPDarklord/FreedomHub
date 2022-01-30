package net.freedom.dev.Commands.Admin;

import net.freedom.dev.Utils.Chat;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminChat implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player player = (Player)sender;

		if(cmd.getName().equalsIgnoreCase("achat")) {

			if(!player.hasPermission("hub.admin")) {
				Chat.noPerms(player);
			}else {
				if(args.length == 0) {
					Chat.sendMessage(player, "&e/ac [Message]...");
				}else{
					@SuppressWarnings("unused")
					int laengeArray = args.length;
					@SuppressWarnings("unused")
					int indexArray = 0;
					String text = "";
					for (int i = 0; i < args.length; i++) {
						text += args[i] + " ";
					}
					for(Player pls : Bukkit.getOnlinePlayers()) {
						if(pls.hasPermission("hub.admin")) {
							pls.sendMessage("§8[§4Admin§8]:§b<§6" + sender.getName() + "§b> §e" + text);

						}
					}
				}



			}
		}
		return false;
	}
}

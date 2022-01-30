package net.freedom.dev.Commands.Admin;


import net.freedom.dev.Utils.Chat;

import org.bukkit.Bukkit;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;




public class Invsee implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args ) {
		if (cmd.getName().equalsIgnoreCase("invsee")) { // If the player typed /basic then do the following...
			if(sender instanceof Player) {
				Player player = (Player)sender;
				if(!player.hasPermission("hub.invsee")) {
					sender.sendMessage("§cNot enough perms!");
				}else{
					if(args.length == 0) {
						Chat.sendMessage(player, "&e/invsee <name> ");
						return true;
					}
					Player t = Bukkit.getServer().getPlayer(args[0]);
					if( t == null){
						Chat.sendMessage(player, "The player is offline, you can not open an offline players inv!");
						return true;
					}
					if (args.length == 1){
						player.openInventory(t.getInventory());
						Chat.sendMessage(player, "You have opened " + t.getDisplayName() + "'s invetory.");
					}
				}

			}
		}
		return true;


	}

}

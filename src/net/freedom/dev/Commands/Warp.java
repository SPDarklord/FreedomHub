package net.freedom.dev.Commands;

import net.freedom.dev.Main;
import net.freedom.dev.Utils.Chat;
import net.freedom.dev.Utils.Warps;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Warp implements CommandExecutor {
	
	Main pr;
	
	public Warp(Main pr) {
		this.pr = pr;
	}
	
	public boolean onCommand(CommandSender cs, Command cmd, String tag, String[] args) {
		if (cs instanceof Player) {
			Player player = (Player)cs;
			
			if(cmd.getName().equalsIgnoreCase("warp")) {
			if (args.length == 0) {
				String s = "";
				for (String ss : Warps.get().getWarps()) {
					
						s = ss + ", " + s;
					
				}
				if (s == "") {
					Chat.get();
					Chat.sendMessage(player, "No places found");
				} else {
					Chat.get();
					Chat.sendMessage(player, "Usage: /warp <gametype>");
					//Chat.sendMessage(player, "&bPlaces ("+Warps.get().getWarps().size()+"): &c" + s);
				}
				
			} else if (args.length == 1) {

				String low = args[0].toLowerCase();
				
				if (Warps.get().isWarp(low)) {
				
						
							Warps.get().teleport(player, low);
							Chat.get();
							//Chat.sendMessage(player, "Going to &a" + low);
						
					 
				 } else {
					 Chat.get();
					Chat.sendMessage(player, "Place not found!");
				 }		
			} else if (args.length == 2) {
				if (player.isOp() || player.hasPermission("hub.admin")){
					if (args[0].equalsIgnoreCase("create") || args[0].equalsIgnoreCase("set")) {
						if (Warps.get().isWarp(args[1])) {
							Warps.get().setWarp(args[1], player.getLocation());
							Chat.get();
							Chat.sendMessage(player, "Place " + args[1] + " set.");
						} else {
							Warps.get().createWarp(args[1], player);
						}
					} else if (args[0].equalsIgnoreCase("delete") || args[0].equalsIgnoreCase("remove")) {
						Warps.get().removeWarp(player, args[1]);
					} else {
						Chat.get();
						Chat.sendMessage(player, "Incorrect Usage: /" + tag + " <create|set|delete|remove> <place>");
					}
				} else {
					Chat.get();
					Chat.sendMessage(player, "Incorrect Usage: /" + tag + " <place>");
				}
			} else {
				Chat.get();
				Chat.sendMessage(player, "Incorrect Usage: /" + tag + " <place>");
			}
			}
		}
		
		return false;
	}
	
}
package net.freedom.dev.Commands.Staff;

import net.freedom.dev.Utils.Chat;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Teleport implements CommandExecutor {
	
	public boolean onCommand(CommandSender cs, Command cmd, String tag, String[] args) {
		
		if(cs instanceof Player) {
			
			Player player = (Player)cs;
			if (player.hasPermission("net.staff")) {
			if(cmd.getName().equalsIgnoreCase("tp") || cmd.getName().equalsIgnoreCase("teleport")) {
				if (args.length == 1) {
					
					if (args[0].equalsIgnoreCase("all")) {
						if (player.hasPermission("net.admin")) {
							for (Player players : Bukkit.getOnlinePlayers()) {
								players.teleport(player);
								Chat.get();
								Chat.sendMessage(players, player.getDisplayName() + " has teleported everyone..");
							}
						} else {
							Chat.get();
							Chat.noPerms(player);
						}
					} else {
						
						Player target = Bukkit.getPlayer(args[0]);
						
						if (target != null) {
							
							player.teleport(target);
							
							Chat.get();
							Chat.sendMessage(player, "Teleporting to &a" + target.getDisplayName());
							
							Chat.get();
							
						} else {
							
							Chat.get();
							Chat.sendMessage(player, "Player not found");
							
						}
					}
					
				} else if (args.length == 2) {
					
					Player p1 = Bukkit.getPlayer(args[0]);
					Player p2 = Bukkit.getPlayer(args[1]);
					
					if (p1 != null && p2 != null) {
						
						p1.teleport(p2);
						
						Chat.get();
						Chat.sendMessage(player, "Teleporting " + p1.getDisplayName() + " to " + p2.getDisplayName());
						
						Chat.get();
						Chat.sendMessage(p1, "You have been teleported to " + p2.getDisplayName() + " by "+player.getDisplayName());
						Chat.get();
						Chat.sendMessage(p2, p1.getDisplayName() + " has been teleported to you by "+player.getDisplayName());
						
						Chat.get();
						
					} else {
						
						int x = 0;
						int z = 0;
						
						try{
							x = Integer.parseInt(args[0]);
							z = Integer.parseInt(args[1]);
							
							Location location = new Location(player.getWorld(), x, player.getWorld().getHighestBlockYAt(x, z), z);
							player.teleport(location);
							
							Chat.get();
							
						}catch(NumberFormatException ex) {
							
							Chat.get();
							Chat.sendMessage(player, "Usage:");
							Chat.get();
							Chat.sendMessage(player, "/" + tag + " <name> &e- &eTeleport to a player");
							Chat.get();
							Chat.sendMessage(player, "/" + tag + " <player1> <player2> &e- &eTeleport a player to another.");
							Chat.get();
							Chat.sendMessage(player, "/" + tag + " <x> <z> &e- &eTeleport to an X and Z coordinate");
							
						}
						
					}
					
				} else {
					
					Chat.get();
					Chat.sendMessage(player, "Usage:");
					Chat.get();
					Chat.sendMessage(player, "/" + tag + " <name> &a- &eTeleport to a player");
					Chat.get();
					Chat.sendMessage(player, "/" + tag + " <player1> <player2> &e- &eTeleport a player to another.");
					Chat.get();
					Chat.sendMessage(player, "/" + tag + " <x> <z> &a- &eTeleport to an X and Z coordinate");
					
				}
				
			} else {
				
				Chat.get();
				Chat.noPerms(player);
				
			}
			
		}
		}
		return false;
	}
	
}

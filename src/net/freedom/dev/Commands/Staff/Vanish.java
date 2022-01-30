package net.freedom.dev.Commands.Staff;

import net.freedom.dev.Utils.Chat;
import net.freedom.dev.Utils.Lists;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;


public class Vanish implements CommandExecutor {
	
	public boolean onCommand(CommandSender cs, Command cmd, String tag, String[] args) {
		
		if(cs instanceof Player) {
			
			Player player = (Player)cs;
			if(cmd.getName().equalsIgnoreCase("vanish")) {
			if (player.hasPermission("net.staff")) {
				
				if (Lists.get().vanish.contains(player.getName())) {
					Lists.get().vanish.remove(player.getName());
					for (Player players : Bukkit.getOnlinePlayers()) {
						players.showPlayer(player);
					}
					player.removePotionEffect(PotionEffectType.INVISIBILITY);
					Chat.get();
					Chat.sendMessage(player, "You can now be seen.");
					
				} else {
					Lists.get().vanish.add(player.getName());
					for (Player players : Bukkit.getOnlinePlayers()) {
						if (!players.hasPermission("see.vanish")){
							players.hidePlayer(player);
						}
					}
					Chat.get();
					//player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 2));
					Chat.sendMessage(player, "You are now vanished to non-admins, and can't pickup items.");
					
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

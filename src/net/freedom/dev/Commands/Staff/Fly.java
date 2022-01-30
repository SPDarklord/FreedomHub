package net.freedom.dev.Commands.Staff;


import net.freedom.dev.Utils.Chat;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {

	public boolean onCommand(CommandSender cs, Command cmd, String tag, String[] args) {

		if(cs instanceof Player) {

			Player player = (Player)cs;


			if(cmd.getName().equalsIgnoreCase("fly")) {
				if(!player.hasPermission("net.Fly")) {
					Chat.noPerms(player);
				}else {
					if(args.length == 0) {
						if(player.getAllowFlight() == false) {
							player.setAllowFlight(true);
							Chat.sendMessage(player, "Fly mode: &aEnabled");
						}else {
							player.setAllowFlight(false);
							player.setFallDistance(0F);
							Chat.sendMessage(player, "Fly mode: &4Disabled");
						}
					}else {
						if(args.length == 1) {
							Player target = Bukkit.getPlayer(args[0]);
							if(!(target == null)) {
								if(target.getAllowFlight() == false) {

									target.setAllowFlight(true);
									Chat.sendMessage(player, "Fly mode &aEnabled &ffor: &c" + target.getName());
									Chat.sendMessage(target, "Fly mode &aEnabled &fby &c" + player.getName());
								}else {
									target.setAllowFlight(false);
									target.setFallDistance(0F);
									target.setFlying(false);
									Chat.sendMessage(player, "Fly mode &4Disabled &ffor: &c" + target.getName());
									Chat.sendMessage(target, "Fly mode &4Disabled &fby &c" + player.getName());
								}
							}else {
								Chat.sendMessage(player, "User not online!");
							}
						}
					}
				}
			}
		}

		return false;
	}
}
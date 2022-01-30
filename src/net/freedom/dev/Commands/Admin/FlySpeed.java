package net.freedom.dev.Commands.Admin;

import net.freedom.dev.Utils.Chat;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class FlySpeed implements CommandExecutor {

	public boolean onCommand(CommandSender cs, Command cmd, String tag, String[] args) {

		if(cs instanceof Player) {

			Player player = (Player)cs;



			if(cmd.getName().equalsIgnoreCase("flyspeed"))
				if (player.hasPermission("net.staff")) {

					if (args.length == 0) {

						Chat.sendMessage(player, "Incorrect usage: /" + tag + " speed");

					} else if (args.length == 1) {
						// experimental fly speed
						try{
							float speed = Float.parseFloat(args[0])/10;

							if (speed > 10){
								Chat.sendMessage(player, "Out of bounds speed: 1 - 10");
								return false;
							}

							player.setFlySpeed(speed);
							Chat.sendMessage(player, "Your fly speed has been modified.");
						}catch(IllegalArgumentException ex){Chat.get();
						Chat.sendMessage(player, "Out of bounds speed: 1 - 10");}

					} else {

						Chat.sendMessage(player, "Usage: /" + tag + " speed");

					}

				} else {

					Chat.noPerms(player);

				}

		}

		return false;
	}
}
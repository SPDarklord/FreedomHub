package net.freedom.dev.Commands;

import net.freedom.dev.Main;
import net.freedom.dev.Utils.Chat;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Spawn implements CommandExecutor {

	Main main;

	public Spawn(Main main) {
		this.main = main;
	}

	@SuppressWarnings("static-access")
	public boolean onCommand(CommandSender cs, Command cmd, String tag, String[] args) {

		if(cs instanceof Player) {

			Player player = (Player)cs;

			if(cmd.getName().equalsIgnoreCase("spawn")) {
				if (args.length == 0) {


					if (main.teleport(player)) {
					} else {

						Chat.get().sendMessage(player, "Spawn is not set.");

					}


				} else if (args.length == 1) {

					if (player.hasPermission("hub.admin")) {
						if (args[0].equalsIgnoreCase("set")) {
							main.setSpawn(player.getLocation());
							Chat.get().sendMessage(player, "Spawn set.");
						}  else {
							Chat.get().sendMessage(player, "Usage: /" + tag);
						}
					} else {
						Chat.get().sendMessage(player, "Usage: /" + tag);
					}

				} else {

					Chat.get().sendMessage(player, "Usage: /" + tag);

				}

			}
		}
		return false;
	}
}
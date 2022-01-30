package net.freedom.dev.Commands.Staff;

import net.freedom.dev.Utils.Chat;

import org.apache.commons.lang.WordUtils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gamemode implements CommandExecutor {

	@SuppressWarnings({ "static-access" })
	public boolean onCommand(CommandSender cs, Command cmd, String tag, String[] args) {

		if(cs instanceof Player) {

			Player player = (Player)cs;

			if(cmd.getName().equalsIgnoreCase("gm")) {			
				if (player.hasPermission("freedom.gamemode")) {

					if (args.length == 0) {

						switch(player.getGameMode()) {
						case ADVENTURE:
							player.setGameMode(GameMode.SURVIVAL);
							break;
						case SURVIVAL:
							player.setGameMode(GameMode.CREATIVE);
							break;
						case CREATIVE:
							player.setGameMode(GameMode.SURVIVAL);
							break;
						default:
							player.setGameMode(GameMode.SURVIVAL);
							break;
						}

						sendGamemode(player);

					} else if (args.length == 1) {

						switch(args[0].toLowerCase()) {
						case "c":
						case "creative":
						case "1":
							player.setGameMode(GameMode.CREATIVE);
							sendGamemode(player);
							break;
						case "a":
						case "adventure":
						case "2":
							player.setGameMode(GameMode.ADVENTURE);
							sendGamemode(player);
							break;
						case "s":
						case "survival":
						case "0":
							player.setGameMode(GameMode.SURVIVAL);
							sendGamemode(player);
							break;
						default:
							Chat.get().sendMessage(player, "Unknown gamemode: 0/1/2/s/c/a/survival/creative/adventure");
							break;
						}

					} else if (args.length == 2) {

						Player tar = Bukkit.getPlayer(args[1]);

						if (tar != null) {

							switch(args[0].toLowerCase()) {
							case "c":
							case "creative":
							case "1":
								tar.setGameMode(GameMode.CREATIVE);
								sendGamemode(player, tar);
								break;
							case "a":
							case "adventure":
							case "2":
								tar.setGameMode(GameMode.ADVENTURE);
								sendGamemode(player, tar);
								break;
							case "s":
							case "survival":
							case "0":
								tar.setGameMode(GameMode.SURVIVAL);
								sendGamemode(player, tar);
								break;
							default:
								Chat.get().sendMessage(player, "Unknown gamemode: 0/1/2/s/c/a/survival/creative/adventure");
								break;
							}

						} else {

							Chat.get().sendMessage(player, "Player not found.");

						}

					} else {

						Chat.get().sendMessage(player, "Usage: /" + tag + " <mode> [player]");

					}

				} else {

					Chat.get().noPerms(player);

				}
			}
		}

		return false;
	}

	@SuppressWarnings("static-access")
	void sendGamemode(Player player) {
		Chat.get().sendMessage(player, "Gamemode changed to: &a" + WordUtils.capitalize(player.getGameMode().name().toLowerCase()));
	}

	@SuppressWarnings("static-access")
	void sendGamemode(Player player, Player who) {
		Chat.get().sendMessage(player, "Gamemode changed to: &a" + WordUtils.capitalize(player.getGameMode().name().toLowerCase()) + " &fBy: &c" + player.getName());
		Chat.get().sendMessage(player, "&c" + who.getName() + "&f's &fGamemode updated to &a" + WordUtils.capitalize(who.getGameMode().name().toLowerCase()));
	}

}

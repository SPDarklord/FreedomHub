package net.freedom.dev.Commands.Admin;

import net.freedom.dev.Utils.Chat;
import net.freedom.dev.Utils.Lists;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class endsummon implements CommandExecutor{

	public boolean onCommand(CommandSender cs, Command cmd, String tag, String[] args) {

		Player player = (Player)cs;

		if(cmd.getName().equalsIgnoreCase("endersummon")){

			if(player.hasPermission("hub.sadmin")){

				Location loc = player.getLocation();
				World world = player.getWorld();

				if(args.length == 0){
					Chat.sendMessage(player, "A name must be given!");
					Chat.sendMessage(player, "/endersummon <name>");
				}

				if(args.length > 0){
					Entity entity =  world.spawnEntity(loc, EntityType.ENDER_CRYSTAL);
					StringBuilder builder = new StringBuilder();

					for (int i = 0; i < args.length; i++) {
					    builder.append(args[i]).append(" ");
					}

					String text = builder.toString().trim();


					String EntityName = ChatColor.translateAlternateColorCodes('&', text);
					entity.setCustomName(EntityName);
					entity.setCustomNameVisible(true);
					Lists.get().EnderCrystals.add(entity.getCustomName());
				}

			}
		}
		return false;
	}


}

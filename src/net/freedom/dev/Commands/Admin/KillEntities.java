package net.freedom.dev.Commands.Admin;

import net.freedom.dev.Utils.Chat;
import net.freedom.dev.Utils.Lists;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EnderCrystal;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class KillEntities implements CommandExecutor{

	public boolean onCommand(CommandSender cs, Command cmd, String tag, String[] args) {


		if(cmd.getName().equalsIgnoreCase("entitykill")){

			Player player = (Player)cs;
			if(cs.hasPermission("hub.sadmin")){

				int count = 0;
				for(Entity en : player.getWorld().getEntities()){
					if(!(en instanceof Player)) {

						count++;
						en.remove();

					}
					if(en instanceof EnderCrystal){
						Lists.get().EnderCrystals.clear();
					}
				}
				Chat.sendMessage(player, count + " entities killed.");


			}
		}
		return false;
	}


}


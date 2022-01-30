package net.freedom.dev.Commands.Admin;

import net.freedom.dev.Runnables.Items;
import net.freedom.dev.Utils.Chat;
import net.freedom.dev.Utils.Lists;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Clear implements CommandExecutor{

	public boolean onCommand(CommandSender cs, Command cmd, String tag, String[] args) {

		Player player = (Player)cs;
		if(cmd.getName().equalsIgnoreCase("clear")) {	
			if (player.hasPermission("net.admin")) {

				if(args.length == 0){
					Chat.sendMessage(player, "Clearing your inventory!");
					player.getInventory().setArmorContents(null);
					Items.items(player);
					if(Lists.get().armour.contains(player.getName())){
						Lists.get().armour.remove(player.getName());
					}
				}
				if(args.length == 1){
						Player target = Bukkit.getPlayer(args[0]);
						if(target == null){
							Chat.sendMessage(cs, "That player is offline!");
						}else{
							Chat.sendMessage(target, "Your inventory is being cleared!");
							Chat.sendMessage(cs, "You cleared " + target.getName() + "'s inventory!");
							target.getInventory().setArmorContents(null);
							Items.items(target);
							if(Lists.get().armour.contains(target.getName())){
								Lists.get().armour.remove(target.getName());
							}
						}
					}
				}


			}
		
		if(cmd.getName().equalsIgnoreCase("clearall")){
			for(Player pls : Bukkit.getOnlinePlayers()){
				Chat.sendMessage(pls, "Your inventory was cleared!");
				if(pls.hasPermission("hub.admin")){
					Chat.sendMessage(pls, "Everyones inventory was cleared by " + cs.getName());
				}
				pls.getInventory().setArmorContents(null);
				Items.items(pls);
				if(Lists.get().armour.contains(pls.getName())){
					Lists.get().armour.remove(pls.getName());
				}
			}
		}


		return false;
	}

}

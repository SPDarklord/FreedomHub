package net.freedom.dev.Runnables;

import net.freedom.dev.Utils.Chat;
import net.freedom.dev.Utils.Lists;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ClearAll {

	public static void clearAll(){		
		for(Player pls : Bukkit.getOnlinePlayers()){
			if(pls.hasPermission("net.staff")){
				Chat.sendMessage(pls, "A reload or error occured, all players inventorys have been cleared to prevent bugs.");
				Chat.sendMessage(pls, "If no admins are on please inform them this happened.");
			}
			pls.getInventory().clear();
			pls.getInventory().setArmorContents(null);
			pls.getInventory().setBoots(null);
			pls.getInventory().setChestplate(null);
			pls.getInventory().setHelmet(null);
			pls.getInventory().setLeggings(null);
			if(Lists.get().armour.contains(pls.getName())){
				Lists.get().armour.remove(pls.getName());
			}
			Items.items(pls);
		}
		
	}
	
}

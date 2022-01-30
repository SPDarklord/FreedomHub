package net.freedom.dev.Listeners;

import net.freedom.dev.Utils.BungeeUtils;
import net.freedom.dev.Utils.Chat;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class EnderListener implements Listener{
	
	@EventHandler
	public void EnderRightClick(PlayerInteractEntityEvent e){
		Player player = e.getPlayer();
		Entity entity = e.getRightClicked();
		EntityType etype = entity.getType();
		if(etype == EntityType.ENDER_CRYSTAL){
			String eName = entity.getName();
			if(ChatColor.stripColor(eName).equalsIgnoreCase("prison")){
				Chat.sendMessage(player, "You are being taken to Prison!");
				BungeeUtils.sendToServer(player, "Prison1");
			}
			if(ChatColor.stripColor(eName).equalsIgnoreCase("factions")){
				Chat.sendMessage(player, "You are being taken to Factions!");
				BungeeUtils.sendToServer(player, "Factions1");
			}
			
		}
		
	}
	


}

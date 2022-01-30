package net.freedom.dev.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class StopInvMovement implements Listener{
	
	@EventHandler
	 public void onDrop(PlayerDropItemEvent event) {
	  Player player = event.getPlayer();
	  if(!(player.hasPermission("hub.staff"))){
	   event.setCancelled(true);
	  }
	 }

	 @EventHandler
	 public void onInventoryClick(InventoryClickEvent event) {
	  Player player = (Player) event.getWhoClicked();
	  if(!(player.hasPermission("hub.staff"))){
	   event.setCancelled(true);
	  }
	 }

	 @EventHandler
	 public void onInventoryDrag(InventoryDragEvent event) {
	  Player player = (Player) event.getWhoClicked();
	  if(!(player.hasPermission("hub.staff"))){
	   event.setCancelled(true);
	  }
	 }

	 @EventHandler
	 public void onPlayerPickupItem(PlayerPickupItemEvent event) {
	  Player player = event.getPlayer();
	  if(!(player.hasPermission("hub.staff"))){
	   event.setCancelled(true);
	  }
	 }
	

	
}

package net.freedom.dev.Listeners.GUIS;


import net.freedom.dev.Runnables.GUIS.CompassGui;
import net.freedom.dev.Runnables.GUIS.MinigameGui;
import net.freedom.dev.Utils.BungeeUtils;
import net.freedom.dev.Utils.Chat;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class Compass implements Listener {
	//item changed to netherstar
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		org.bukkit.event.block.Action Action = e.getAction();
		if(Action == org.bukkit.event.block.Action.PHYSICAL || e.getItem() == null || e.getItem().getType() == Material.AIR){
			return;
		}
		if(e.getItem().getType() == Material.NETHER_STAR){
			CompassGui.openGUI(e.getPlayer());
		}
	}


	@EventHandler
	public void onInventoryClickEvent(InventoryClickEvent e) {    	
		if(ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("Servers")){

			Player p = (Player) e.getWhoClicked();
			e.setCancelled(true);

/*			if(e.getCurrentItem() == null 
					|| e.getCurrentItem().getType() == Material.AIR 
					|| !e.getCurrentItem().hasItemMeta()) {
				p.closeInventory();
				return;
			}*/

			switch (e.getCurrentItem().getType()){
			case EMERALD:
				p.chat("/spawn");
				p.closeInventory();
				Chat.sendMessage(p, "You have been taken to the Spawn!");
				break;
			case TNT:
				p.closeInventory();
				Chat.sendMessage(p, "Taking you to factions!");
				BungeeUtils.sendToServer(p, "Factions1");
				break;
			case IRON_FENCE:
				p.closeInventory();
				Chat.sendMessage(p, "Taking you to prison!");
				BungeeUtils.sendToServer(p, "Prison1");
				break;
			case BOW:
				MinigameGui.openMGUI(p);
				break;
			default:
				break;
			}
		}
		if(ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("MiniGames")){

			Player p = (Player) e.getWhoClicked();
			e.setCancelled(true);

/*			if(e.getCurrentItem() == null 
					|| e.getCurrentItem().getType() == Material.AIR 
					|| !e.getCurrentItem().hasItemMeta()) {
				p.closeInventory();
				return;
			}*/

			switch (e.getCurrentItem().getType()){
			case BEDROCK:
				Chat.sendMessage(p, "This is coming soon!");
				p.closeInventory();
				break;
			case DIAMOND_SPADE:
				p.closeInventory();
				Chat.sendMessage(p, "This is coming soon!");
				break;
			case ARROW:
				p.closeInventory();
				CompassGui.openGUI(p);
				break;
			case EMERALD:
				p.chat("/spawn");
				p.closeInventory();
				Chat.sendMessage(p, "You have been taken to the Spawn!");
				break;
			case ICE:
				p.closeInventory();
				Chat.sendMessage(p, "This is coming soon!");
				break;
			case IRON_SWORD:
				p.closeInventory();
				Chat.sendMessage(p, "This is coming soon!");
				break;
			case SNOW_BALL:
				p.closeInventory();
				Chat.sendMessage(p, "Taking you to Paintball!");
				p.chat("/warp paintball");
				break;
			default:
				break;
			}
		}
	}
}


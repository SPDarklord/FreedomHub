package net.freedom.dev.Listeners.GUIS;

import net.freedom.dev.Runnables.GUIS.DonorTools;
import net.freedom.dev.Utils.Chat;
import net.freedom.dev.Utils.Lists;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class DonorGui implements Listener{
	
	private static ItemStack getColorArmor(Material m) {
		ItemStack i = new ItemStack(m, 1);
		LeatherArmorMeta meta = (LeatherArmorMeta) i.getItemMeta();
		meta.setDisplayName("" + ChatColor.BOLD + "Disco Armour");
		i.setItemMeta(meta);
		return i;
	}

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		org.bukkit.event.block.Action Action = e.getAction();
		if(Action == org.bukkit.event.block.Action.PHYSICAL || e.getItem() == null || e.getItem().getType() == Material.AIR){
			return;
		}
		if(e.getItem().getType() == Material.DIAMOND){
			DonorTools.openDGUI(e.getPlayer());
		}
	}

	@EventHandler
	public void onInventoryClickEvent(InventoryClickEvent e) {    	
		if(ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("Donor Items!")){

			Player p = (Player) e.getWhoClicked();
			e.setCancelled(true);

			if(e.getCurrentItem() == null 
					|| e.getCurrentItem().getType() == Material.AIR 
					|| !e.getCurrentItem().hasItemMeta()) {
				p.closeInventory();
				return;
			}
			switch (e.getCurrentItem().getType()) {
			case LEATHER_CHESTPLATE:
				if(!(Lists.get().armour.contains(p.getName()))){
					Lists.get().armour.add(p.getName());
					p.getInventory().setHelmet(getColorArmor(Material.LEATHER_HELMET));
					p.getInventory().setChestplate(getColorArmor(Material.LEATHER_CHESTPLATE));
					p.getInventory().setLeggings(getColorArmor(Material.LEATHER_LEGGINGS));
					p.getInventory().setBoots(getColorArmor(Material.LEATHER_BOOTS));
					Chat.sendMessage(p, "You have been given Disco Armour!");
					Chat.sendMessage(p, "Go spread the power of the Disco!");
				}else{
					Lists.get().armour.remove(p.getName());
					p.getInventory().setArmorContents(null);
					Chat.sendMessage(p, "Your Disco Armour has been removed!");
					Chat.sendMessage(p, "You lost the groove!");
				}
				p.closeInventory();
				break;
			default:
				break;
			}
			
		}

	}
}

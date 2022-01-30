package net.freedom.dev.Runnables.GUIS;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class DonorTools {

	static ArrayList<String> lore = new ArrayList<String>();
	static String lore1 = "" + ChatColor.AQUA  + "A set of clothes designed for the greatest of parties!";
	static String lore2 = "" + ChatColor.AQUA  + "Watch at how it changes colour!";
	public static void openDGUI(Player player) {
		
		Inventory i = Bukkit.createInventory(null, 27, "" +  ChatColor.DARK_AQUA + ChatColor.ITALIC + "Donor Items!");
		ItemStack DArmor = new ItemStack(Material.LEATHER_CHESTPLATE);
		ItemMeta DArmorMeta = DArmor.getItemMeta();
		
		DArmorMeta.setDisplayName("" + ChatColor.BLUE + ChatColor.BOLD + "Disco Armour");
		lore.clear();
		lore.add(lore1);
		lore.add(lore2);
		DArmorMeta.setLore(lore);
		DArmor.setItemMeta(DArmorMeta);
		
		
		i.setItem(10, DArmor);
		player.openInventory(i);
	}
	
}

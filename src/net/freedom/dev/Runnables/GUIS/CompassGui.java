package net.freedom.dev.Runnables.GUIS;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CompassGui {

	static ArrayList<String> pLore = new ArrayList<String>();
	static ArrayList<String> fLore = new ArrayList<String>();
	static ArrayList<String> sLore = new ArrayList<String>();
	static String pPlayerCount1 = "" + ChatColor.GREEN + "Players on Prison:";
	static String hPlayerCount1 = "" + ChatColor.GREEN + "Players on Hub: " + Bukkit.getOnlinePlayers().size();
	static String fPlayerCount1 = "" + ChatColor.GREEN + "Players on Factions:";
	public static void openGUI(Player player) {
		Inventory i = Bukkit.createInventory(null, 27, "" + ChatColor.DARK_GREEN +  ChatColor.BOLD +"Servers");


		ItemStack spawn = new ItemStack(Material.EMERALD);
		ItemMeta spawnMeta = spawn.getItemMeta();

		ItemStack Factions = new ItemStack(Material.TNT);
		ItemMeta FactionsMeta = Factions.getItemMeta();

		ItemStack MiniGames = new ItemStack(Material.BOW);
		ItemMeta MiniGamesMeta = MiniGames.getItemMeta();

		ItemStack Prison = new ItemStack(Material.IRON_FENCE);
		ItemMeta PrisonMeta = Prison.getItemMeta();

		MiniGamesMeta.setDisplayName("" + ChatColor.BLUE + ChatColor.BOLD + "MiniGames");
		MiniGames.setItemMeta(MiniGamesMeta);

		PrisonMeta.setDisplayName("" + ChatColor.BLUE + ChatColor.BOLD + "Prison");
		pLore.clear();
		pLore.add(pPlayerCount1);
		PrisonMeta.setLore(pLore);
		Prison.setItemMeta(PrisonMeta);

		FactionsMeta.setDisplayName("" + ChatColor.BLUE + ChatColor.BOLD + "Factions");
		fLore.clear();
		fLore.add(fPlayerCount1);
		FactionsMeta.setLore(fLore);
		Factions.setItemMeta(FactionsMeta);
		spawnMeta.setDisplayName("" + ChatColor.BLUE + ChatColor.BOLD + "Spawn");
		sLore.clear();
		sLore.add(hPlayerCount1);
		spawnMeta.setLore(sLore);
		spawn.setItemMeta(spawnMeta);



		i.setItem(10, Factions);
		i.setItem(13, MiniGames);
		i.setItem(16, Prison);
		i.setItem(22, spawn);

		player.openInventory(i);

	}
}

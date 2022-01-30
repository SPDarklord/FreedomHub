package net.freedom.dev.Runnables.GUIS;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MinigameGui {

	public static void openMGUI( Player player) {
		Inventory i = Bukkit.createInventory(null, 45, ChatColor.AQUA +"MiniGames");


		ItemStack spawn = new ItemStack(Material.EMERALD);
		ItemMeta spawnMeta = spawn.getItemMeta();

		ItemStack back = new ItemStack(Material.ARROW);
		ItemMeta backMeta = back.getItemMeta();

		ItemStack comingsoon = new ItemStack(Material.BEDROCK);
		ItemMeta comingsoonmeta = comingsoon.getItemMeta();

		ItemStack Freeze = new ItemStack(Material.ICE);
		ItemMeta FreezeMeta = Freeze.getItemMeta();

		ItemStack Spleef = new ItemStack(Material.DIAMOND_SPADE);
		ItemMeta SpleefMeta = Spleef.getItemMeta();

		ItemStack Paintball = new ItemStack(Material.SNOW_BALL);
		ItemMeta PaintballMeta = Paintball.getItemMeta();

		ItemStack sg = new ItemStack(Material.IRON_SWORD);
		ItemMeta sgMeta = sg.getItemMeta();


		backMeta.setDisplayName("" + ChatColor.BLUE + ChatColor.BOLD + "Back");
		back.setItemMeta(backMeta);

		comingsoonmeta.setDisplayName("" + ChatColor.RED + ChatColor.BOLD + "Coming soon");
		comingsoon.setItemMeta(comingsoonmeta);

		sgMeta.setDisplayName("" + ChatColor.BLUE + ChatColor.BOLD + "Survival Games");
		sg.setItemMeta(sgMeta);

		PaintballMeta.setDisplayName("" + ChatColor.BLUE + ChatColor.BOLD + "Paintball");
		Paintball.setItemMeta(PaintballMeta);

		FreezeMeta.setDisplayName("" + ChatColor.BLUE + ChatColor.BOLD + "Freeze Tag");
		Freeze.setItemMeta(FreezeMeta);

		SpleefMeta.setDisplayName("" + ChatColor.BLUE + ChatColor.BOLD + "Spleef");
		Spleef.setItemMeta(SpleefMeta);

		spawnMeta.setDisplayName("" + ChatColor.BLUE + ChatColor.BOLD + "Spawn");
		spawn.setItemMeta(spawnMeta);

		i.setItem(1, comingsoon);
		i.setItem(3, Spleef);
		i.setItem(5, comingsoon);
		i.setItem(7, comingsoon);
		i.setItem(20, back);
		i.setItem(22, spawn);
		i.setItem(24, comingsoon);
		i.setItem(37, Freeze);
		i.setItem(39, sg);
		i.setItem(41, comingsoon);
		i.setItem(43, Paintball);

		player.openInventory(i);

	}

}

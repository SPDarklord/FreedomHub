package net.freedom.dev.Runnables;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;

public class Items {

	
	static ArrayList<String> loreD = new ArrayList<String>();
	static String Done = "" + ChatColor.GREEN + ChatColor.BOLD + "Right click to change your donor perks!";
	static ArrayList<String> lore = new ArrayList<String>();
	static String one = "" + ChatColor.GREEN + ChatColor.BOLD + "Right click to disable players";
    static ArrayList<String> loreBook = new ArrayList<String>();
    static String BookOne = "" + ChatColor.AQUA +  "Info about the server!";
	@SuppressWarnings("deprecation")
	public static void items(Player player){
		player.getInventory().clear();
		player.getInventory().setArmorContents(null);
		
		ItemStack Compass = new ItemStack(Material.NETHER_STAR);
		ItemMeta CompassMeta = Compass.getItemMeta();
		CompassMeta.setDisplayName("" + ChatColor.GREEN + ChatColor.BOLD + "Games");
		Compass.setItemMeta(CompassMeta);
		
		ItemStack Cannon = new ItemStack(Material.BLAZE_ROD);
		ItemMeta CannonMeta = Cannon.getItemMeta();
		CannonMeta.setDisplayName("" + ChatColor.RED + ChatColor.BOLD + "Fun Cannon!");
		Cannon.setItemMeta(CannonMeta);

		ItemStack Clock = new ItemStack(Material.INK_SACK, 1, DyeColor.getByData((byte) 10).getData());
		ItemMeta ClockMeta = Clock.getItemMeta();
		ClockMeta.setDisplayName("" + ChatColor.GREEN + ChatColor.BOLD + "§ePlayer Visability ➠ §2Enabled");
		lore.clear();
		lore.add(one);
		ClockMeta.setLore(lore);
		Clock.setItemMeta(ClockMeta);
		player.getInventory().clear();
		player.getInventory().setArmorContents(null);
		ItemStack Donor = new ItemStack(Material.DIAMOND);
		ItemMeta DonorMeta = Donor.getItemMeta();
		DonorMeta.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "Donor Items");
		loreD.clear();
		loreD.add(Done);
		DonorMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
		Donor.setItemMeta(DonorMeta);

		ItemStack Book = new ItemStack(Material.WRITTEN_BOOK);
		BookMeta bookmeta = (BookMeta)Book.getItemMeta();
		bookmeta.setDisplayName("" + ChatColor.BOLD + ChatColor.GREEN  + "Info");
		loreBook.clear();
		loreBook.add(BookOne);
		bookmeta.setLore(loreBook);
		bookmeta.setTitle("" + ChatColor.BOLD + ChatColor.BLUE + "Info");
		bookmeta.setPages("" + ChatColor.BLACK + ChatColor.BOLD + "      Freedom" + "" + ChatColor.RESET + "" + ChatColor.DARK_GREEN + "\nWelcome to the Freedom! ");
		bookmeta.setAuthor("Freedom!");
		Book.setItemMeta(bookmeta);
		

		
		player.getInventory().clear();
		player.getInventory().setArmorContents(null);
		player.getInventory().setItem(0, Compass);
		player.getInventory().setItem(4, Clock);
		player.getInventory().setItem(6, Book);
		if(player.hasPermission("hub.donor")){
			player.getInventory().setItem(8, Donor);
		}
		if(player.hasPermission("hub.donor")){
			player.getInventory().setItem(6, Cannon);
		}
		
	}
	
}

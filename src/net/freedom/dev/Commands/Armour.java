package net.freedom.dev.Commands;

import net.freedom.dev.Utils.Chat;
import net.freedom.dev.Utils.Lists;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class Armour implements CommandExecutor{

	private static ItemStack getColorArmor(Material m) {
		ItemStack i = new ItemStack(m, 1);
		LeatherArmorMeta meta = (LeatherArmorMeta) i.getItemMeta();
		meta.setDisplayName("" + ChatColor.BOLD + "Disco Armour");
		i.setItemMeta(meta);
		return i;
	}

	public boolean onCommand(CommandSender cs, Command cmd, String tag, String[] args) {

		Player player = (Player)cs;
		if(cmd.getName().equalsIgnoreCase("armour")){

			if(player.hasPermission("hub.armour")){

				if(args.length == 0){
					player.getInventory().setHelmet(getColorArmor(Material.LEATHER_HELMET));
					player.getInventory().setChestplate(getColorArmor(Material.LEATHER_CHESTPLATE));
					player.getInventory().setLeggings(getColorArmor(Material.LEATHER_LEGGINGS));
					player.getInventory().setBoots(getColorArmor(Material.LEATHER_BOOTS));
					Chat.sendMessage(player, "You have been equipped with Disco armour!");
					Chat.sendMessage(player, "Go spread the power of the Disco!");
					Lists.get().armour.add(player.getName());
				}
				if(args.length > 1){
					Chat.sendMessage(player, "/armour to set your own armour");
					Chat.sendMessage(player, "/armour <name> to set someone elses armour!");
				}
				if(cs.hasPermission("hub.givearmour")){
					if(args.length == 1){
						Player target = Bukkit.getPlayer(args[0]);
						if(target == null){
							Chat.sendMessage(cs, "User not online!");
							return false;
						}else{
							target.getInventory().setHelmet(getColorArmor(Material.LEATHER_HELMET));
							target.getInventory().setChestplate(getColorArmor(Material.LEATHER_CHESTPLATE));
							target.getInventory().setLeggings(getColorArmor(Material.LEATHER_LEGGINGS));
							target.getInventory().setBoots(getColorArmor(Material.LEATHER_BOOTS));
							Chat.sendMessage(target, "You have been equipped with Disco armour!");
							Chat.sendMessage(target, "Go spread the power of the Disco!");
							Chat.sendMessage(player, "You gave " + target.getName() + " Disco Armour!");
							Lists.get().armour.add(target.getName());
						}
					}
				}else{
					Chat.sendMessage(cs, "You do not have the perms to do this!");
				}
			}
//such code join our team!
		}

		return false;

	}

}

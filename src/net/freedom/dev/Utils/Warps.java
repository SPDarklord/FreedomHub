package net.freedom.dev.Utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import net.freedom.dev.Main;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Warps {
	
	private static Warps ins = new Warps();
	
	public static Warps get() {
		return ins;
	}
	
	public FileConfiguration	config;
	private File				f;
	
	public void setup(Main pr) {
	
		this.f = new File(pr.getDataFolder(), "arenas.yml");
		
		try {
			if (!this.f.exists())
				
				this.f.createNewFile();
			
		} catch (Exception localException) {
		}
		
		reloadWarps();
		saveWarps();
		reloadWarps();
		
	}
	
	public boolean isWarp(String s) {
		return getWarps().contains(s.toLowerCase());
	}
	
	public void reloadWarps() {
		this.config = YamlConfiguration.loadConfiguration(f);
	}
	
	public void saveWarps() {
		try {
			this.config.save(this.f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("static-access")
	public boolean teleport(Player player, String arena) {
		if (arena.equalsIgnoreCase("spawn")){
			return Main.get().teleport(player);
		}
		if (isWarp(arena)) {
			player.teleport(getWarp(arena));
			return true;
		} else {
			Chat.get().sendMessage(player, "Warp not found!");
			return false;
		}
	}
	
	public List<String> getWarps() {
		return config.getStringList("arenas");
	}
	
	public void addWarpToConfig(String name) {
		name = name.toLowerCase();
		List<String> config = this.config.getStringList("arenas");
		config.add(name);
		this.config.set("arenas", config);
		saveWarps();
	}
	
	public void removeWarpFromConfig(String name) {
		name = name.toLowerCase();
		List<String> config = this.config.getStringList("arenas");
		config.remove(name);
		this.config.set("arenas", config);
		saveWarps();
	}
	
	@SuppressWarnings("static-access")
	public void createWarp(String name2, Player player) {
		
		if (isWarp(name2)) {
			
			Chat.get().sendMessage(player, "Place already exists!");
			
		} else {
			
			Location location = player.getLocation();
			
			String name = name2.toLowerCase();
			setWarp(name, location);
			config.set(name + ".name", name2);
			
			addWarpToConfig(name);
			
			saveWarps();
			
			Chat.get().sendMessage(player, "Place " + name2 + " set.");
			Chat.get().log(player.getName() + " has created an place : " + name2 + ".");
			
		}
		
	}
	
	@SuppressWarnings("static-access")
	public void removeWarp(Player player, String name) {
		
		name = name.toLowerCase();
		
		if (isWarp(name)) {
			
			config.set(name, null);
			
			removeWarpFromConfig(name);
			
			saveWarps();
			
			Chat.get().sendMessage(player, "Place &l" + name + "&c removed.");
			Chat.get().log(player.getName() + " has removed an place : " + name + ".");
			
		} else {

			Chat.get().sendMessage(player, "Place not found!");
			
		}
		
	}
	
	public void setWarp(String name, Location l) {

		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		float yaw = l.getYaw();
		float pitch = l.getPitch();
		
		String worldName = l.getWorld().getName();
		
		name = name.toLowerCase();
		
		config.set(name + ".x", x);
		config.set(name + ".y", y);
		config.set(name + ".z", z);
		config.set(name + ".yaw", yaw);
		config.set(name + ".pitch", pitch);
		config.set(name + ".world", worldName);
		
		saveWarps();
	}
	
	private Location getWarp(String name) {
		
		name = name.toLowerCase();
		
		int x, y, z;
		float yaw, pitch;
		World worldName;
		
		x = config.getInt(name + ".x");
		y = config.getInt(name + ".y");
		z = config.getInt(name + ".z");
		pitch = config.getInt(name + ".pitch");
		yaw = config.getInt(name + ".yaw");
		worldName = Bukkit.getWorld(config.getString(name + ".world"));
		
		return new Location(worldName, x + 0.5D, y + 0.5D, z + 0.5D, yaw, pitch);
		
	}
}

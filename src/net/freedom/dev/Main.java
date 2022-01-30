package net.freedom.dev;



import net.freedom.dev.Commands.Armour;
import net.freedom.dev.Commands.Spawn;
import net.freedom.dev.Commands.Warp;
import net.freedom.dev.Commands.Admin.AdminChat;
import net.freedom.dev.Commands.Admin.Broadcast;
import net.freedom.dev.Commands.Admin.ChatClear;
import net.freedom.dev.Commands.Admin.Clear;
import net.freedom.dev.Commands.Admin.FlySpeed;
import net.freedom.dev.Commands.Admin.GC;
import net.freedom.dev.Commands.Admin.Invsee;
import net.freedom.dev.Commands.Admin.KillEntities;
import net.freedom.dev.Commands.Admin.TPM;
import net.freedom.dev.Commands.Admin.endsummon;
import net.freedom.dev.Commands.Staff.Fly;
import net.freedom.dev.Commands.Staff.Gamemode;
import net.freedom.dev.Commands.Staff.Teleport;
import net.freedom.dev.Commands.Staff.Vanish;
import net.freedom.dev.Listeners.DyeHidePlayers;
import net.freedom.dev.Listeners.EnderListener;
import net.freedom.dev.Listeners.Explode;
import net.freedom.dev.Listeners.LaunchPads;
import net.freedom.dev.Listeners.PlayerJoin;
import net.freedom.dev.Listeners.PlayerQuit;
import net.freedom.dev.Listeners.StopInvMovement;
import net.freedom.dev.Listeners.GUIS.Compass;
import net.freedom.dev.Listeners.GUIS.DonorGui;
import net.freedom.dev.Runnables.FunCannon;
import net.freedom.dev.Utils.Warps;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{

	public static Main plugin;
	@Override
	public void onEnable() {
		plugin = this;
		Bukkit.getMessenger().registerOutgoingPluginChannel(plugin, "BungeeCord");
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new StopInvMovement(), this);		
		Bukkit.getServer().getPluginManager().registerEvents(new Compass(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new DonorGui(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new DyeHidePlayers(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerQuit(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new LaunchPads(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new FunCannon(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Explode(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new EnderListener(), this);
		getCommand("warp").setExecutor(new Warp(this));
		getCommand("endersummon").setExecutor(new endsummon());
		getCommand("entitykill").setExecutor(new KillEntities());
		getCommand("Spawn").setExecutor(new Spawn(this));
		getCommand("broadcast").setExecutor(new Broadcast());
		getCommand("playermessages").setExecutor(new TPM());
		getCommand("armour").setExecutor(new Armour());
		getCommand("chatclear").setExecutor(new ChatClear());
		getCommand("clearall").setExecutor(new Clear());
		getCommand("invsee").setExecutor(new Invsee());
		getCommand("clear").setExecutor(new Clear());
		getCommand("fly").setExecutor(new Fly());
		getCommand("gm").setExecutor(new Gamemode());
		getCommand("tp").setExecutor(new Teleport());
		getCommand("teleport").setExecutor(new Teleport());
		getCommand("GC").setExecutor(new GC());
		getCommand("vanish").setExecutor(new Vanish());
		getCommand("flyspeed").setExecutor(new FlySpeed());
		getCommand("achat").setExecutor(new AdminChat());
		Warps.get().setup(this);
	}

	@Override
	public void onDisable() {
		Bukkit.getServer().getLogger().info("The hub is shutting down or reloading");
		Bukkit.getServer().getLogger().info("*Villager Voice* Bai Bai");
		plugin = null;
	}



	public void setSpawn(Location l) {
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		float yaw = l.getYaw();
		float pitch = l.getPitch();
		String worldName = l.getWorld().getName();
		getConfig().set("spawn.world", worldName);
		getConfig().set("spawn.x", x);
		getConfig().set("spawn.y", y);
		getConfig().set("spawn.z", z);
		getConfig().set("spawn.pitch", pitch);
		getConfig().set("spawn.yaw", yaw);
		saveConfig();
	}

	public boolean teleport(Player player) {
		if (getConfig().isString("spawn.world")) {
			player.teleport(getSpawn());
			return true;
		} else {
			return false;
		}
	}
	public Location getSpawn() {
		int x, y, z;
		float yaw, pitch;
		World worldName;
		reloadConfig();
		x = getConfig().getInt("spawn.x");
		y = getConfig().getInt("spawn.y");
		z = getConfig().getInt("spawn.z");
		yaw = getConfig().getInt("spawn.yaw");
		pitch = getConfig().getInt("spawn.pitch");
		worldName = Bukkit.getWorld(getConfig().getString("spawn.world"));
		return new Location(worldName, x + 0.5D, y + 0.5D, z + 0.5D, yaw, pitch);
	}

	public static Plugin getPlugin() {
		return plugin;
	}

	public static Main get() {
		return (Main)Bukkit.getPluginManager().getPlugin("Hub");
	}

	public static Main getInstance(){
		return plugin;
	}

}

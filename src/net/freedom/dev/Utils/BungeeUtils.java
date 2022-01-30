package net.freedom.dev.Utils;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.freedom.dev.Main;

import org.bukkit.entity.Player;

public class BungeeUtils {
	
	public static void sendToServer(Player p, String Server){
		ByteArrayOutputStream bytearray = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(bytearray);
		try {
			out.writeUTF("ConnectOther");
			out.writeUTF(p.getName());
			out.writeUTF(Server);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		p.sendPluginMessage(Main.getInstance(), "BungeeCord", bytearray.toByteArray());
	}
	

	

}

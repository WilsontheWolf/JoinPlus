package me.WilsontheWolf.JoinPlus;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin implements Listener {
	Server server = Bukkit.getServer();
	ConsoleCommandSender console = server.getConsoleSender();
	Logger log = Bukkit.getLogger();
	FileConfiguration config = this.getConfig();
	@Override
	public void onEnable()
	{
		getServer().getPluginManager().registerEvents(this, this);
		console.sendMessage("Thank you for using"+ChatColor.GOLD+ChatColor.BOLD+ChatColor.UNDERLINE+" Join+");
		this.saveDefaultConfig();
		console.sendMessage(parseColor(config.getString("joinmsg"), "username"));
	}
	@Override
	public void onDisable()
	{
		try{
			config.options().copyDefaults(true);
			saveConfig();
		} catch (Exception e) {
			log.warning("Join+ had an error saving the config!");
			log.warning(e.toString());
		}
	}
	

	  @EventHandler
	  public void onJoin(PlayerJoinEvent event) {
		  Player player= event.getPlayer();
		  event.setJoinMessage(null);
		  String message = parseColor(config.getString("joinmsg"), player.getDisplayName());
		  Bukkit.broadcastMessage(message);

	  }
	  
	  @EventHandler
	  public void onLeave(PlayerQuitEvent event) {
		  Player player= event.getPlayer();
		  event.setQuitMessage(null);
		  String message = parseColor(config.getString("leavemsg"), player.getDisplayName());
		  Bukkit.broadcastMessage(message);
	  }
	  
	  public String parseColor(String str , String name) {
		  str = str.replace("{player}", name);
		  str = str.replace("{aqua}", ChatColor.AQUA.toString());
		  str = str.replace("{black}", ChatColor.BLACK.toString());
		  str = str.replace("{blue}", ChatColor.BLUE.toString());
		  str = str.replace("{dark_aqua}", ChatColor.DARK_AQUA.toString());
		  str = str.replace("{dark_blue}", ChatColor.DARK_BLUE.toString());
		  str = str.replace("{dark_gray}", ChatColor.DARK_GRAY.toString());
		  str = str.replace("{dark_green}", ChatColor.DARK_GREEN.toString());
		  str = str.replace("{dark_purple}", ChatColor.DARK_PURPLE.toString());
		  str = str.replace("{dark_red}", ChatColor.DARK_RED.toString());
		  str = str.replace("{gold}", ChatColor.GOLD.toString());
		  str = str.replace("{gray}", ChatColor.GRAY.toString());
		  str = str.replace("{green}", ChatColor.GREEN.toString());
		  str = str.replace("{light_purple}", ChatColor.LIGHT_PURPLE.toString());
		  str = str.replace("{red}", ChatColor.RED.toString()); 
		  str = str.replace("{white}", ChatColor.WHITE.toString());
		  str = str.replace("{yellow}", ChatColor.YELLOW.toString());
		  str = str.replace("{bold}", ChatColor.BOLD.toString());
		  str = str.replace("{italic}", ChatColor.ITALIC.toString());
		  str = str.replace("{strikethrough}", ChatColor.STRIKETHROUGH.toString());
		  str = str.replace("{underline}", ChatColor.UNDERLINE.toString());
		  str = str.replace("{reset}", ChatColor.RESET.toString());
		  return(str);
		  }
}

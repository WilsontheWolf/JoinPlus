package me.WilsontheWolf.JoinPlus;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin implements Listener {
	Server server = Bukkit.getServer();
	ConsoleCommandSender console = server.getConsoleSender();

	@Override
	public void onEnable()
	{
		getServer().getPluginManager().registerEvents(this, this);
		console.sendMessage("Thank you for using"+ChatColor.GOLD+ChatColor.BOLD+ChatColor.UNDERLINE+" Join+");
	}
	@Override
	public void onDisable()
	{
		console.sendMessage(ChatColor.DARK_RED+"Note: Join+ has been disabled and your chat messages will now be the defaults!");
	}
	

	  @EventHandler
	  public void onJoin(PlayerJoinEvent event) {
		  Player player= event.getPlayer();
		  event.setJoinMessage(null);
		  String message = ChatColor.BOLD+""+ChatColor.GOLD+"["+ChatColor.DARK_GREEN+"+"+ChatColor.GOLD+"]"+ChatColor.RESET+" "+ChatColor.DARK_AQUA+player.getDisplayName()+ChatColor.DARK_PURPLE+" has joined the game!";
		  Bukkit.broadcastMessage(message);

	  }
	  
	  @EventHandler
	  public void onLeave(PlayerQuitEvent event) {
		  Player player= event.getPlayer();
		  event.setQuitMessage(null);
		  String message = ChatColor.BOLD+""+ChatColor.GOLD+"["+ChatColor.DARK_RED+"-"+ChatColor.GOLD+"]"+ChatColor.RESET+" "+ChatColor.DARK_AQUA+player.getDisplayName()+ChatColor.DARK_PURPLE+" has left the game!";
		  Bukkit.broadcastMessage(message);

	  }
}

package me.crafter.mc.choptreew;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class ChopTreeW extends JavaPlugin {

	public final ChopListener pl = new ChopListener();

	public void onEnable(){
    	getServer().getPluginManager().registerEvents(this.pl, this);
    	new Storage(this);
    }
	
	
    public void onDisable(){
    	Storage.saveOff();
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, final String[] args){
    	if (cmd.getName().equals("choptree")){
    		if (args.length < 1){
    			sender.sendMessage(ChatColor.RED + "/choptree <on/off>");
    			return true;
    		}
    		if (args[0].equals("on")){
    			if (!(sender instanceof Player)){
    				sender.sendMessage("����̨�����ɶ?");
    			}
    			Player p = (Player)sender;
    			p.sendMessage(ChatColor.GOLD + "[ChopTreeW] " + ChatColor.GREEN + "�㿪����һ������");
    			Storage.turn(p, true);
    			return true;
    		} else if (args[0].equals("off")){
    			if (!(sender instanceof Player)){
    				sender.sendMessage("����̨�����ɶ?");
    			}
    			Player p = (Player)sender;
    			p.sendMessage(ChatColor.GOLD + "[ChopTreeW] " + ChatColor.RED + "��ر���һ������");
    			Storage.turn(p, false);
    			return true;
    		} else {
    			sender.sendMessage(ChatColor.RED + "/choptree <on/off>");
    			return true;
    		}
    	}
    	return true;
    }
	
}

package net.aidantaylor.custardpie.Commands;

import net.aidantaylor.custardpie.Utils.Items;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PieCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)){
			sender.sendMessage("Only players can use this command!");
			return true;
		}
		
		if(cmd.getName().equalsIgnoreCase("custardpie")){
			
			Player player = (Player) sender;
			player.getInventory().addItem(Items.custardPie);
			
			return true;
		}
		
		return false;
	}
	
	

}

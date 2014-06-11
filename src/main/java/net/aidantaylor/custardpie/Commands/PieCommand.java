package net.aidantaylor.custardpie.Commands;

import net.aidantaylor.custardpie.Utils.Items;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class PieCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)){
			sender.sendMessage("Only players can use this command!");
			return true;
		}
		
		if(cmd.getName().equalsIgnoreCase("custardpie")){
			
			Player player = (Player) sender;
			// Give the player a custard pie.
			ItemStack c = Items.custardPie.clone();
			
			// If there are args, set the amount of pies to that
			if(args.length >= 1){
				
				String amount = args[0];
				
				c.setAmount(Integer.parseInt(amount));
			}
			
			player.getInventory().addItem(c);
			
			return true;
		}
		
		return false;
	}
	
	

}

package net.aidantaylor.custardpie.Commands;

import net.aidantaylor.custardpie.Utils.Chat;
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
		
		if(cmd.getName().equalsIgnoreCase("custardpie") || cmd.getName().equalsIgnoreCase("cpie")){
			
			Player player = (Player) sender;

            if (!player.hasPermission("custardpie.spawn"))
            {
                Chat.sendMessage(player, "&cYou do not have permission to use this command!");
                return true;
            }

            ItemStack c = Items.custardPie.clone();

            if (player.hasPermission("custardpie.spawn.multi"))
            {
                String amount = args[0];

                c.setAmount(Integer.parseInt(amount));


                Chat.sendMessage(player, "&eYou have received &6" + amount + " &epies!");

                player.getInventory().addItem(new ItemStack[] { c });

                return true;
            }else{
                Chat.sendMessage(player, "&cYou do not have permission to use this command!");
                return true;
            }
        player.getInventory().addItem(c);

        Chat.sendMessage(player, "&eEnjoy your custard pie!");
        return true;

    }
		
		return false;
	}
	
	

}

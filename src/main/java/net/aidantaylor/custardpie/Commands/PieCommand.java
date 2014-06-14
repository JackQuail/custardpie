package net.aidantaylor.custardpie.commands;

import net.aidantaylor.custardpie.utils.Items;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class PieCommand implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("custardpie")) {
			if (args.length < 1) {
				if (sender instanceof Player && (sender.hasPermission("custardpie.spawn") || sender.isOp())) {
					givePie((Player) sender);
					sender.sendMessage(ChatColor.GREEN + "Enjoy your custard pie!");
				} else {
					sender.sendMessage(ChatColor.RED + "You don't have permission for this command!");
				}
			} else if (sender.hasPermission("custardpie.spawn.multi")) {
				int amount = new Integer(args[1]);
				
				if (amount < 1) {
					sender.sendMessage(ChatColor.RED + "You cant have " + amount + " pies!");
				} else {
					givePie((Player) sender, amount);
					
					if (amount == 1) {
						sender.sendMessage(ChatColor.GREEN + "Enjoy your custard pie!");
					} else {
						sender.sendMessage(ChatColor.GREEN + "Enjoy your " + amount + " custard pies!");
					}
				}
			} else {
				sender.sendMessage(ChatColor.RED + "Incorrect number of arguments!");
			}
		}

		return false;
	}
	
	public void givePie(Player player) {
		givePie(player, 1);
	}
	
	public void givePie(Player player, int amount) {
		ItemStack c = Items.custardPie.clone();
		c.setAmount(amount);
		player.getInventory().addItem(new ItemStack[] { c });
	}
}
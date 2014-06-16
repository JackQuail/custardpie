package net.aidantaylor.custardpie.commands;

import net.aidantaylor.custardpie.utils.Items;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class PieCommand implements CommandExecutor {
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("custardpie")) {
			if (args.length < 1) {
				if (sender instanceof Player && (sender.hasPermission("custardpie.spawn") || sender.isOp())) {
					givePie((Player) sender);
					sender.sendMessage(ChatColor.GREEN + "Enjoy your custard pie!");
				} else {
					sender.sendMessage(ChatColor.RED + "You don't have permission for this command!");
				}
			} else if (args.length < 3) {
				if (isInteger(args[0]) && sender instanceof Player && (sender.hasPermission("custardpie.spawn.multi") || sender.isOp())) {
					int amount = Integer.parseInt(args[0]);

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
					Player recipient = (Player) Bukkit.getServer().getPlayer(args[0]);

					if (args.length == 2 && (isInteger(args[1]) && sender.hasPermission("custardpie.spawn.multi.other"))) {
						int amount = Integer.parseInt(args[1]);

						if (amount < 1) {
							sender.sendMessage(ChatColor.RED + "You cant give " + amount + " pies to " + ChatColor.DARK_RED + args[0] + ChatColor.RED + "!");
						} else if(recipient != null){
							if (amount == 1) {
								givePie(recipient);
								sender.sendMessage(ChatColor.DARK_GREEN + sender.getName() + ChatColor.GREEN + " gave you a custard pie!");
							} else {
								givePie(recipient, amount);
								sender.sendMessage(ChatColor.DARK_GREEN + sender.getName() + ChatColor.GREEN + " gave you " + amount + " custard pies!");
							}
						} else {
							sender.sendMessage(ChatColor.DARK_RED + args[0] + ChatColor.RED + " is offline!");
						}
					} else if (sender.hasPermission("custardpie.spawn.other")) {
						if(recipient != null){
							givePie(recipient);
							sender.sendMessage(ChatColor.DARK_GREEN + sender.getName() + ChatColor.GREEN + " gave you a custard pie!");
						} else {
							sender.sendMessage(ChatColor.DARK_RED + args[0] + ChatColor.RED + " is offline!");
						}
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

	public static boolean isInteger(String s) {
	    try {
	        Integer.parseInt(s);
	        return true;
	    } catch(NumberFormatException e) { 
	        return false; 
	    }
	}
}
package net.aidantaylor.custardpie.Events;

import net.aidantaylor.custardpie.Utils.Chat;
import net.aidantaylor.custardpie.Utils.Items;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;

public class CraftEvent
        implements Listener
{
    @EventHandler
    public void onCraft(CraftItemEvent event)
    {
        System.out.print("5");
        if (event.getRecipe().getResult().isSimilar(Items.custardPie))
        {
            if (!(event.getWhoClicked() instanceof Player)) {
                return;
            }
            Player p = (Player)event.getWhoClicked();
            if (!p.hasPermission("custardpie.create"))
            {
                event.setCurrentItem(new ItemStack(Material.AIR));
                p.closeInventory();
                event.setCancelled(true);
                Chat.sendMessage(p, "&cYou do not have permission to craft custard pies!");
            }
        }
    }
}

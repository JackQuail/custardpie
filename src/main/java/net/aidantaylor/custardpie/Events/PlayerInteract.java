package net.aidantaylor.custardpie.Events;

import net.aidantaylor.custardpie.Utils.Items;
import net.aidantaylor.custardpie.Utils.Utils;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Created by CaLxCyMru on 10/06/2014.
 */
public class PlayerInteract implements Listener {

    @EventHandler
    public void onPieInteract(PlayerInteractEvent event){
    	if(!event.getItem().isSimilar(Items.custardPie)) return;
        	event.setCancelled(true);
        
        if(event.getAction() != Action.RIGHT_CLICK_AIR) return;

        
        Utils.throwCustardPie(event.getPlayer());
        ItemStack i = event.getItem();
        
        event.getPlayer().getInventory().setItemInHand(new ItemStack(Material.AIR));
        
        if(i.getAmount() >= 2){
        	i.setAmount(i.getAmount() - 1);
        	event.getPlayer().getInventory().setItemInHand(i);
        }
    }
}

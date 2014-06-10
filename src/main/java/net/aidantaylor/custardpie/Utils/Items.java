package net.aidantaylor.custardpie.Utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by CaLxCyMru on 10/06/2014.
 */
public class Items {

    public static ItemStack custardPie = createItemStack(Material.PUMPKIN_PIE,1,0,"&eCustard Pie","&6Throw me!");

    public static ItemStack createItemStack(Material mat, int amount, int damage, String name, String lore) {
        ItemStack itemStack = new ItemStack(mat, amount, (short) damage);

        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name.replaceAll("&", "§"));
        List<String> list = new ArrayList<String>();
        if(lore.contains("\n")){
            for(String next : lore.split("\n")){
                list.add(next.replaceAll("&","§"));
            }
            itemMeta.setLore(list);
        }else {
            itemMeta.setLore(Arrays.asList(lore.replaceAll("&", "§")));
        }

        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

}

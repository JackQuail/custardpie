package net.aidantaylor.custardpie.Utils;

import org.bukkit.entity.Player;

public class Chat
{
    public static void sendMessage(Player player, String message)
    {
        player.sendMessage(message.replaceAll("&", "§"));
    }
}

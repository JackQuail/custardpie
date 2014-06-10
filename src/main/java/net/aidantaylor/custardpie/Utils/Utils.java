package net.aidantaylor.custardpie.Utils;

import net.aidantaylor.custardpie.Main;

import org.bukkit.EntityEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import de.ase34.flyingblocksapi.FlyingBlock;

/**
 * Created by CaLxCyMru on 10/06/2014.
 */
public class Utils {


	public static void throwPie(Player player){
		final Snowball s = player.launchProjectile(Snowball.class);
		new BukkitRunnable(){
			final FlyingBlock f = new FlyingBlock(Material.PUMPKIN, (byte) 4) {
				public void onTick(){
					if (getBukkitEntity().getVelocity().lengthSquared() != 0.0D) {
						getBukkitEntity().setVelocity(new Vector(0, 0, 0));
					}
				}
			};
			@Override
			public void run() {
				Location l = s.getLocation();
				if(s.isDead()){
					this.cancel();
					return;
				}
				f.spawn(l);
				for(Entity near : s.getNearbyEntities(10, 10, 10)){
					if(near instanceof Player){
						near.playEffect(EntityEffect.FIREWORK_EXPLODE);
					}
				}
				new BukkitRunnable(){
					public void run(){
						f.remove();
					}

				}.runTaskLater(Main.instance, 5L);

			}
		}.runTaskTimer(Main.instance,0L,0L);

		sendMessage(player,"&bYou just threw a pie!");
	}

	public static void sendMessage(Player player, String message){
		player.sendMessage(message.replaceAll("&","§"));
	}


}

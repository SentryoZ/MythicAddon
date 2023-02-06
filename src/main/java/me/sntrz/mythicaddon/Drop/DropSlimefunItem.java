package me.sntrz.mythicaddon.Drop;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;

public class DropSlimefunItem {

    ItemStack drop_item = new ItemStack(Material.AIR);
    World world = null;
    Location location = null;

    public void DropItem(String world_name, double x, double y, double z, String slime_fun_item_id, Integer quantity) {
        this.prepareItem(slime_fun_item_id, quantity);
        this.prepareWorld(world_name);
        if (world.equals(null)) {
            return;
        }
        this.prepareLocation(x, y, z);

        this.dropItem();
    }

    public void prepareItem(String item_id, Integer quantity) {
        SlimefunItem slime_item = SlimefunItem.getById(item_id);
        if (!slime_item.equals(null)) {
            this.drop_item = slime_item.getItem();
            this.drop_item.setAmount(quantity);
        }
    }

    public void prepareWorld(String world_name) {
        this.world = Bukkit.getWorld(world_name);
    }

    public void prepareLocation(double x, double y, double z) {
        this.location = new Location(this.world, x, y, z);
    }

    public void dropItem() {
        this.world.dropItemNaturally(this.location, this.drop_item);
    }
}


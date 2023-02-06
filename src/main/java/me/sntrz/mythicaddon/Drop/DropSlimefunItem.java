package me.sntrz.mythicaddon.Drop;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.lumine.mythic.api.adapters.AbstractEntity;
import io.lumine.mythic.api.adapters.AbstractItemStack;
import io.lumine.mythic.api.adapters.AbstractWorld;
import io.lumine.mythic.api.config.MythicLineConfig;
import io.lumine.mythic.api.drops.DropMetadata;
import io.lumine.mythic.api.drops.IItemDrop;
import io.lumine.mythic.bukkit.adapters.BukkitItemStack;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;


public class DropSlimefunItem implements IItemDrop {

    ItemStack drop_item = new ItemStack(Material.AIR);

    public void prepareItem(String item_id, Integer quantity) {
        SlimefunItem slime_item = SlimefunItem.getById(item_id);
        if (!slime_item.equals(null)) {
            this.drop_item = slime_item.getItem();
            this.drop_item.setAmount(quantity);
        }
    }

    public DropSlimefunItem(MythicLineConfig config, String argument) {
        String item_id = config.getString(new String[]{"id", "i"}, "COPPER_DUST", argument);
        Integer quantity = config.getInteger(new String[]{"amount", "a"}, 0);

        prepareItem(item_id.toUpperCase(), quantity);

    }

    @Override
    public AbstractItemStack getDrop(DropMetadata dropMetadata, double v) {
        return new BukkitItemStack(this.drop_item);
    }
}


package me.sntrz.mythicaddon;

import io.lumine.mythic.api.config.MythicLineConfig;
import io.lumine.mythic.bukkit.adapters.BukkitItemStack;
import io.lumine.mythic.bukkit.events.MythicDropLoadEvent;
import io.lumine.mythic.bukkit.utils.logging.Log;
import io.lumine.mythic.core.drops.droppables.CustomDrop;
import io.lumine.mythic.core.drops.droppables.ItemDrop;
import me.sntrz.mythicaddon.Drop.DropSlimefunItem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class MythicAddon extends JavaPlugin implements Listener {


    @Override
    public void onEnable() {
        // Plugin startup logic
        Log.info("MythicDrop startup-ing");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onMythicDropLoad(MythicDropLoadEvent event) {
        Log.info("MythicDropLoadEvent called for drop " + event.getDropName());

        if (event.getDropName().equalsIgnoreCase("SLIMEFUN")) {
            String line = event.getConfig().getLine();
            MythicLineConfig config = event.getConfig();

            BukkitItemStack item_drop = new DropSlimefunItem(event.getConfig(), event.getArgument()).getDrop_item();

            ItemDrop drop = new ItemDrop(line, config, item_drop);
            event.register(drop);

            Log.info("-- Registered slimefun drop!");
        }
    }
}

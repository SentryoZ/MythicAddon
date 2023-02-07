package me.sntrz.mythicaddon;

import io.lumine.mythic.api.config.MythicLineConfig;
import io.lumine.mythic.api.drops.IDrop;
import io.lumine.mythic.bukkit.adapters.BukkitItemStack;
import io.lumine.mythic.bukkit.events.MythicDropLoadEvent;
import io.lumine.mythic.bukkit.utils.logging.Log;
import io.lumine.mythic.core.drops.droppables.CustomDrop;
import io.lumine.mythic.core.drops.droppables.ItemDrop;
import me.sntrz.mythicaddon.Drop.DropSlimefunItem;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class MythicAddon extends JavaPlugin implements Listener {


    @Override
    public void onEnable() {
        // Plugin startup logic
        Log.info("MythicDrop startup-ing");
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onMythicDropLoad(MythicDropLoadEvent event) {
        if (event.getDropName().equalsIgnoreCase("slimefun")) {
            event.register(new DropSlimefunItem(event.getConfig(), event.getArgument()));
        }
    }
}

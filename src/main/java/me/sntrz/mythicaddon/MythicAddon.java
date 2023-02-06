package me.sntrz.mythicaddon;

import io.lumine.mythic.bukkit.events.MythicDropLoadEvent;
import io.lumine.mythic.bukkit.utils.logging.Log;
import me.sntrz.mythicaddon.Drop.DropSlimefunItem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class MythicAddon extends JavaPlugin implements Listener {

    private Logger logger;

    @Override
    public void onEnable() {
        // Plugin startup logic

        Log.info("MythicDrop startup-ing");
        //

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onMythicDropLoad(MythicDropLoadEvent event) {
        if (event.getDropName().equalsIgnoreCase("slimefun")) {
            event.register(new DropSlimefunItem(event.getConfig(), event.getArgument()));
            Log.info("-- Registered DropSlimefunItem drop!");
        }
    }
}

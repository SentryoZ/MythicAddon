package me.sntrz.mythicaddon;

import io.lumine.mythic.bukkit.events.MythicDropLoadEvent;
import me.sntrz.mythicaddon.Drop.DropSlimefunItem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;
public final class MythicAddon extends JavaPlugin implements Listener {

    private Logger log;
    @Override
    public void onEnable() {
        // Plugin startup logic
            log.info("MythicDrop startup-ing");
        //

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onMythicDropLoad(MythicDropLoadEvent event)	{
        if(event.getDropName().equalsIgnoreCase("slimefun"))	{
            event.register(new DropSlimefunItem(event.getConfig(), event.getArgument()));
            log.info("-- Registered DropSlimefunItem drop!");
        }
    }
}

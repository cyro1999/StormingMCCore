package com.Cyro1999.StormingMCCore.Listeners;

import com.Cyro1999.StormingMCCore.StormingMCCore;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class SMC_PlayerListener implements Listener {
    
    private final StormingMCCore plugin;

    public SMC_PlayerListener(StormingMCCore plugin)
    {
        this.plugin = plugin;
    }
    
    public void onPlayerJoin(PlayerJoinEvent event)
    {
       if (StormingMCCore.plugin.getConfig().getStringList("staff.owner").contains(event.getPlayer().getName()))
        {
           event.getPlayer().chat("/ne prefix " + event.getPlayer().getName() + "'&4&lOWNER &r' ");
        }
        
       else if (StormingMCCore.plugin.getConfig().getStringList("staff.overseer").contains(event.getPlayer().getName()))
        {
           event.getPlayer().chat("/ne prefix " + event.getPlayer().getName() + "'&b&lOVERSEER &r' ");
        }
               
       else if (StormingMCCore.plugin.getConfig().getStringList("staff.admin").contains(event.getPlayer().getName()))
        {
           event.getPlayer().chat("/ne prefix " + event.getPlayer().getName() + "'&c&lADMIN &r' ");
        }
                       
       else if (StormingMCCore.plugin.getConfig().getStringList("staff.helper").contains(event.getPlayer().getName()))
        {
           event.getPlayer().chat("/ne prefix " + event.getPlayer().getName() + "'&3&lHELPER &r' ");
        }
                                
       else if (StormingMCCore.plugin.getConfig().getStringList("staff.moderator").contains(event.getPlayer().getName()))
        {
           event.getPlayer().chat("/ne prefix " + event.getPlayer().getName() + "'&5&lMOD &r' ");
        }
    }
    
}

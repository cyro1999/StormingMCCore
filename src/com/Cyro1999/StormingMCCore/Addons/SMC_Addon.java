package com.Cyro1999.StormingMCCore.Addons;

import com.Cyro1999.StormingMCCore.SMC_Util;
import com.Cyro1999.StormingMCCore.StormingMCCore;
import org.bukkit.Server;


public class SMC_Addon {
    
    protected final StormingMCCore plugin;
    protected final Server server;
    protected final SMC_Util util;

    public SMC_Addon(StormingMCCore plugin)
    {
        this.plugin = plugin;
        this.server = plugin.getServer();
        this.util = plugin.util;
    }
    
}

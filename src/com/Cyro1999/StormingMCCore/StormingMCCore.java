package com.Cyro1999.StormingMCCore;

import com.Cyro1999.StormingMCCore.Commands.SMC_CommandHandler;
import com.Cyro1999.StormingMCCore.Commands.SMC_CommandLoader;
import com.Cyro1999.StormingMCCore.Config.SMC_Config;
import com.Cyro1999.StormingMCCore.Listeners.SMC_PlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class StormingMCCore extends JavaPlugin {
   
    public static final String SMC_COMMAND_PATH = "com.Cyro1999.StormingMCCore.Commands";
    public static final String SMC_COMMAND_PREFIX = "Command_";
   // 
   public static FileConfiguration config;  
   public static StormingMCCore plugin;
   public static SMC_Config smcConfig;
   public SMC_Util util;
  
   
    public void onLoad()
    {
        plugin = this;
    }
    
    public void onEnable()
    {
        SMC_Log.info("[StormingMCCore] StormingMCCore plugin by Cyro1999 enabled!");
        
        SMC_CommandLoader.getInstance().scan();
        
        smcConfig = new SMC_Config(plugin, "config.yml");
        smcConfig.saveDefaultConfig();
        config = smcConfig.getConfig();
        
        final PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new SMC_PlayerListener(plugin), plugin);
        
    }

    

    public void onDisable()
    {
        SMC_Log.info("[StormingMCCore] StormingMCCore plugin by Cyro1999 disabled!");
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        return SMC_CommandHandler.handleCommand(sender, cmd, commandLabel, args);
        
    }
   
    
}

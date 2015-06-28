// Credit to the Superior Development team :)

package com.Cyro1999.StormingMCCore.Commands;

import com.Cyro1999.StormingMCCore.SMC_Log;
import com.Cyro1999.StormingMCCore.StormingMCCore;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class SMC_Command
{
    protected StormingMCCore plugin;
    protected Server server;
    private CommandSender commandSender;
    private Class<?> commandClass;

    public SMC_Command()
    {
    }

    

    public void setup(final StormingMCCore plugin, final CommandSender commandSender, final Class<?> commandClass)
    {
        this.plugin = plugin;
        this.server = this.plugin.getServer();
        this.commandSender = commandSender;
        this.commandClass = commandClass;
    }

    public void playerMsg(final CommandSender sender, final String message, final ChatColor color)
    {
        if (sender == null)
        {
            return;
        }
        sender.sendMessage(color + message);
    }

    public void playerMsg(final String message, final ChatColor color)
    {
        playerMsg(commandSender, message, color);
    }

    public void playerMsg(final CommandSender sender, final String message)
    {
        playerMsg(sender, message, ChatColor.GRAY);
    }

    public void playerMsg(final String message)
    {
        playerMsg(commandSender, message);
    }
    

    public boolean senderHasPermission()
    {
        final CommandPermissions permissions = commandClass.getAnnotation(CommandPermissions.class);
        if (permissions != null)
        {
            
            boolean is_senior = false;


            SourceType source = permissions.source();
            boolean block_host_console = permissions.block_Host_Console();

            Player sender_p = null;
            if (this.commandSender instanceof Player)
            {
                sender_p = (Player) this.commandSender;
            }

            if (sender_p == null)
            {
                if (source == SourceType.ONLY_IN_GAME)
                {
                    return false;
                }
            }
            else
            {
                if (source == SourceType.ONLY_CONSOLE)
                {
                    return false;
                }
                
                
            }
            return true;
        }
        else
        {
            SMC_Log.warning(commandClass.getName() + " is missing permissions annotation.");
        }
        return true;
    }

    public Player getPlayer(final String partialname) throws PlayerNotFoundException
    {
        List<Player> matches = server.matchPlayer(partialname);
        if (matches.isEmpty())
        {
            for (Player player : server.getOnlinePlayers())
            {
                if (player.getDisplayName().toLowerCase().contains(partialname.toLowerCase()))
                {
                    return player;
                }
            }
            throw new PlayerNotFoundException(partialname);
        }
        else
        {
            return matches.get(0);
        }
    }

abstract public boolean run(final CommandSender sender, final Player sender_p, final Command cmd, final String commandLabel, final String[] args, final boolean senderIsConsole);

}

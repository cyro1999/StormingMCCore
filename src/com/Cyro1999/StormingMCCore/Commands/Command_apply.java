package com.Cyro1999.StormingMCCore.Commands;

import com.Cyro1999.StormingMCCore.StormingMCCore;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(source = SourceType.BOTH)
@CommandParameters(
        description = "Find out if you can apply!",
        aliases = "staffapply",
        usage = "/<command>")
public class Command_apply extends SMC_Command {
 
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (StormingMCCore.plugin.config.getString("applications_open").equals("true")) {
            playerMsg("So you wish to apply for admin do you? Apply on the forums @ http://stormingmc.boards.net/", ChatColor.GREEN);
        }
        else if (StormingMCCore.plugin.config.getString("applications_open").equals("false")) {
            playerMsg("So you wish to apply for admin do you? Well, I'm sorry. You may not apply at the moment.", ChatColor.BLUE);
        }
        return true;
    }
    
}

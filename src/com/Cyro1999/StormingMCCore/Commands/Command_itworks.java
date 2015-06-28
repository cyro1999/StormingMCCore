package com.Cyro1999.StormingMCCore.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(source = SourceType.BOTH)
@CommandParameters(
        description = ":O is it working!?!!?!!.",
        aliases = "iw",
        usage = "/<command>")
public class Command_itworks extends SMC_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        playerMsg("Don't worry, it works.", ChatColor.BLUE);
        return true;
    }

}

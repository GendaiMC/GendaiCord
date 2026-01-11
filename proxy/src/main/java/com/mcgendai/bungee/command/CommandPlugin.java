package com.mcgendai.bungee.command;

import java.util.Collection;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Plugin;

public class CommandPlugin extends Command
{
    public CommandPlugin()
    {
        super( "gpl" );
    }
    @Override
    public void execute(CommandSender sender, String[] args)
    {
        Collection<Plugin> plugins =
                BungeeCord.getInstance().getPluginManager().getPlugins();

        String pluginList = plugins.stream()
                .map( p -> p.getClass().getSimpleName() )
                .sorted( String.CASE_INSENSITIVE_ORDER )
                .collect( java.util.stream.Collectors.joining( ", " ) );

        sender.sendMessage(
                ChatColor.AQUA + "ℹ Loaded plugins:\n"
                        + ChatColor.GREEN + pluginList
        );
    }
}

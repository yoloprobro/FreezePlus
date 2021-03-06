package me.yonatanx.FreezePlus.cmds;

import me.yonatanx.FreezePlus.FreezePlus;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Yonatan.
 */

public class UnfreezeCmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (!commandSender.hasPermission("freezeplus.unfreeze")){
            commandSender.sendMessage(ChatColor.RED + "No permission.");
            return true;
        }

        if (strings.length != 1){
            commandSender.sendMessage(ChatColor.RED + getSyntax());
            return true;
        }

        Player player = Bukkit.getPlayer(strings[0]);
        FreezePlus.get().getFreezeManager().unfreezePlayer(player);
        commandSender.sendMessage(ChatColor.GRAY + "You have unfroze " + ChatColor.GOLD + player.getName() + ChatColor.GRAY + ".");

        return true;
    }

    private String getSyntax(){
        return "/unfreeze <player>";
    }
}

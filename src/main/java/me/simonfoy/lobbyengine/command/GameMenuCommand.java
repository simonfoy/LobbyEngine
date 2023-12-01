package me.simonfoy.lobbyengine.command;

import me.simonfoy.lobbyengine.menu.GameMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GameMenuCommand implements CommandExecutor {

    private final GameMenu gameMenuItem;

    public GameMenuCommand() {
        this.gameMenuItem = new GameMenu();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            gameMenuItem.openMenu(player);

            return true;
        } else {
            sender.sendMessage("This command can only be run by a player.");
            return false;
        }
    }
}

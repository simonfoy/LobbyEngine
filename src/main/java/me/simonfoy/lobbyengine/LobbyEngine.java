package me.simonfoy.lobbyengine;

import me.simonfoy.lobbyengine.command.GameMenuCommand;
import me.simonfoy.lobbyengine.inventory.LobbyInventory;
import me.simonfoy.lobbyengine.listener.ConnectListener;
import me.simonfoy.lobbyengine.listener.LobbyProtectionListener;
import me.simonfoy.lobbyengine.manager.ScoreboardManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class LobbyEngine extends JavaPlugin {

    private ScoreboardManager scoreboardManager;

    @Override
    public void onEnable() {

        scoreboardManager = new ScoreboardManager(this);

        Bukkit.getPluginManager().registerEvents(new ConnectListener(this), this);
        Bukkit.getPluginManager().registerEvents(new LobbyProtectionListener(), this);
        Bukkit.getPluginManager().registerEvents(new LobbyInventory(), this);

        getCommand("gamemenu").setExecutor(new GameMenuCommand());
    }

    public ScoreboardManager getScoreboardManager() {
        return scoreboardManager;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

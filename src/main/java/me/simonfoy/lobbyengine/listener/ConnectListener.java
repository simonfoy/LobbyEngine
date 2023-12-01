package me.simonfoy.lobbyengine.listener;

import me.simonfoy.lobbyengine.LobbyEngine;
import me.simonfoy.lobbyengine.inventory.LobbyInventory;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class ConnectListener implements Listener {

    private LobbyEngine lobbyEngine;

    public ConnectListener(LobbyEngine lobbyEngine) {
        this.lobbyEngine = lobbyEngine;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        handlePlayerJoin(event.getPlayer());
    }

    public void handlePlayerJoin(Player player) {
        setPlayerGameMode(player);
        player.setHealth(player.getMaxHealth());
        player.setFoodLevel(20);
        player.setSaturation(20);
        setLobbyInventory(player);
        setPlayerScoreboard(player);
        sendWelcomeMessage(player);
        playJoinSound(player);
    }

    private void setPlayerGameMode(Player player) {
        player.setGameMode(GameMode.ADVENTURE);
    }

    private void setLobbyInventory(Player player) {
        player.getInventory().clear();
        LobbyInventory.giveLobbyInventory(player);
    }

    private void setPlayerScoreboard(Player player) {
        lobbyEngine.getScoreboardManager().clearScoreboard(player);
        lobbyEngine.getScoreboardManager().setLobbyScoreboard(player);
    }

    private void sendWelcomeMessage(Player player) {
        player.sendMessage(ChatColor.GREEN + "Welcome to our server!");
    }

    private void playJoinSound(Player player) {
        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f);
    }
}

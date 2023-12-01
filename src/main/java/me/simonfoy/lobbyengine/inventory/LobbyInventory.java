package me.simonfoy.lobbyengine.inventory;

import me.simonfoy.lobbyengine.menu.GameMenu;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class LobbyInventory implements Listener {

    public static void giveLobbyInventory(Player player) {
        Inventory inventory = Bukkit.createInventory(player, 9, "Lobby Menu");

        // Game Menu Item
        ItemStack gameMenuItem = new ItemStack(Material.COMPASS); // Example item
        ItemMeta gameMenuMeta = gameMenuItem.getItemMeta();
        gameMenuMeta.setDisplayName("Game Menu");
        gameMenuItem.setItemMeta(gameMenuMeta);

        // Lobby Selector Item
        ItemStack lobbySelectorItem = new ItemStack(Material.NETHER_STAR); // Example item
        ItemMeta lobbySelectorMeta = lobbySelectorItem.getItemMeta();
        lobbySelectorMeta.setDisplayName("Lobby Selector");
        lobbySelectorItem.setItemMeta(lobbySelectorMeta);

        // Add items to the inventory
        inventory.addItem(gameMenuItem, lobbySelectorItem);

        // Give the player the inventory
        player.getInventory().setContents(inventory.getContents());
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        ItemStack clickedItem = event.getCurrentItem();

        if (clickedItem != null && clickedItem.getType() == Material.COMPASS) {
            if (clickedItem.hasItemMeta() && clickedItem.getItemMeta().hasDisplayName() && "Game Menu".equals(clickedItem.getItemMeta().getDisplayName())) {
                // Open the game menu
                new GameMenu().openMenu((Player) event.getWhoClicked());
                event.setCancelled(true); // Optional: cancel the event to prevent further processing
            }
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {

        Action action = event.getAction();
        if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK || action == Action.LEFT_CLICK_AIR || action == Action.LEFT_CLICK_BLOCK) {
            ItemStack clickedItem = event.getItem();

            if (clickedItem != null && clickedItem.getType() == Material.COMPASS) {
                if (clickedItem.hasItemMeta() && clickedItem.getItemMeta().hasDisplayName() && "Game Menu".equals(clickedItem.getItemMeta().getDisplayName())) {

                    new GameMenu().openMenu((Player) event.getPlayer());
                    event.setCancelled(true);
                }
            }
        }
    }
}

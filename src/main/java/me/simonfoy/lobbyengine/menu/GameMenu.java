package me.simonfoy.lobbyengine.menu;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class GameMenu {

    private final List<GameOption> gameOptions;

    public GameMenu() {

        this.gameOptions = Arrays.asList(
                new GameOption("Bedwars", Material.RED_BED),
                new GameOption("Smash", Material.CREEPER_HEAD),
                new GameOption("CraftRoyale", Material.POTION)
        );
    }

    public void openMenu(Player player) {

        Inventory menu = Bukkit.createInventory(player, 9, "Select a Game");


        for (GameOption option : gameOptions) {
            ItemStack item = new ItemStack(option.getMaterial());
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(option.getName());
            item.setItemMeta(meta);
            menu.addItem(item);
        }


        player.openInventory(menu);
    }

    private static class GameOption {
        private final String name;
        private final Material material;

        public GameOption(String name, Material material) {
            this.name = name;
            this.material = material;
        }

        public String getName() {
            return name;
        }

        public Material getMaterial() {
            return material;
        }
    }
}

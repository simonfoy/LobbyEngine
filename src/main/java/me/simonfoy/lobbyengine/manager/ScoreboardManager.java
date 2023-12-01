package me.simonfoy.lobbyengine.manager;

import me.simonfoy.lobbyengine.LobbyEngine;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ScoreboardManager {

    private LobbyEngine lobbyEngine;

    public ScoreboardManager(LobbyEngine lobbyEngine) {
        this.lobbyEngine = lobbyEngine;
    }

    public void setLobbyScoreboard(Player player) {

        Scoreboard scoreboard = player.getScoreboard();
        Objective objective = scoreboard.registerNewObjective("lobby", "dummy", ChatColor.AQUA + "" + ChatColor.BOLD + "SF GAMES");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);


        LocalDate today = LocalDate.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy");
        String formattedDate = today.format(formatter);

        Score date = objective.getScore(ChatColor.GRAY + formattedDate);
        date.setScore(7);

        Score blankScore6 = objective.getScore("     ");
        blankScore6.setScore(6);

        Score rank = objective.getScore(ChatColor.WHITE + "Rank: " + ChatColor.RED + "getRank");
        rank.setScore(5);

        Score blankScore4 = objective.getScore("   ");
        blankScore4.setScore(4);

        Score lobby = objective.getScore(ChatColor.WHITE + "Lobby: " + ChatColor.GREEN + "1");
        lobby.setScore(3);

        Score blankScore2 = objective.getScore(" ");
        blankScore2.setScore(2);

        Score websiteScore = objective.getScore(ChatColor.AQUA + "www.sf-games.gg");
        websiteScore.setScore(1);

        player.setScoreboard(scoreboard);
    }

    public void clearScoreboard(Player player) {
        Scoreboard clearScoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        player.setScoreboard(clearScoreboard);
    }
}

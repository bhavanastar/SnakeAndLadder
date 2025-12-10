package com.example.snakeandladder;

import com.example.snakeandladder.models.Player;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Client {
    public static void main(String[] args) {
        System.out.println("Starting Snake and Ladder");
        Player player1 = new Player("Anurag", 0);
        Player player2 = new Player("Shreya", 0);
        Queue<Player> players = new LinkedList<>();
        players.add(player1);
        players.add(player2);
        Game game = new Game(10, 2, players);
        game.startGame();
    }
}

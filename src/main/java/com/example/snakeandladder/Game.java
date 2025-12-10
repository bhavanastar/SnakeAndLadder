package com.example.snakeandladder;

import com.example.snakeandladder.models.Board;
import com.example.snakeandladder.models.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Game {
    private Board board;
    private int numDice;
    private int dimensions;
    private Queue<Player> players;
    private List<Player> winners;

    public Game(int dim, int numDice, Queue<Player> players) {
        this.numDice = numDice;
        this.dimensions = dim;
        this.players = players;
        this.board = new Board(dimensions);
        this.winners = new ArrayList<>();
    }

    public void startGame() {
        while(true) {
            Player player = players.poll();
            System.out.println("Player " + player.getName() + " is playing");
            System.out.println("Press 'r' to roll the dice");

            Scanner sc = new Scanner(System.in);
            char input = sc.next().charAt(0);

            player.makeMove(board, numDice);
            if(player.getCurPosition() == board.getCellCount()) {
                System.out.println(player.getName() + " wins!");
                winners.add(player);
            } else {
                players.add(player);
            }
        }
    }

}

package com.example.snakeandladder.models;

import com.example.snakeandladder.utils.DiceUtility;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    private String name;
    private int curPosition;

    public Player(String name, int position) {
        this.name = name;
        this.curPosition = position;
    }

    public void makeMove(Board board, int numDice) {
        int num = DiceUtility.roll(numDice);
        System.out.println("Dice rolled: " + num);
        int finalPosition = curPosition + num;
        if(finalPosition > board.getCellCount()) {
            System.out.println("Invalid position, please try again. ");
            return;
        }
        if(board.isBoardEntityExists(finalPosition)) {
            BoardEntity boardEntity = board.getBoardEntityMap().get(finalPosition);
            System.out.println("We encountered " + boardEntity.getBoardEntityType() + " at position " + finalPosition);
            curPosition = boardEntity.getEnd();
            curPosition = board.getBoardEntityMap().get(finalPosition).getEnd();
            System.out.println("final position: " + curPosition);
        } else {
            curPosition = finalPosition;
            System.out.println("final position: " + finalPosition);
        }
    }
}

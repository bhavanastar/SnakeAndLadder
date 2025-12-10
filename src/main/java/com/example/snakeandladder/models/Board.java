package com.example.snakeandladder.models;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Board {
    private int dimension;
    private int cellCount;
    private Map<Integer, BoardEntity> boardEntityMap;

    public Board(int dimension) {
        this.dimension = dimension;
        this.cellCount = dimension*dimension;
        boardEntityMap = new HashMap<>();

        addSnakesAndLadders();
    }

    private void addSnakesAndLadders() {
        for (int i = 0; i < dimension; i++) {
            addSnake();
            addLadder();
        }
    }

    private void addSnake() {
        int min = 2;
        int max =  cellCount - 1;
        int start = (int)Math.floor(Math.random()*(max-min+1)+min);
        max = start-1;
        int end = (int)Math.floor(Math.random()*(max-min+1)+min);
        if(isBoardEntityExists(start) || isBoardEntityExists(end)) return;
        BoardEntity boardEntity = new BoardEntity(start, end, BoardEntityType.SNAKE);
        boardEntityMap.put(start, boardEntity);
    }

    private void addLadder() {
        int min = 2;
        int max =  cellCount - 1;
        int end = (int)Math.floor(Math.random()*(max-min+1)+min);
        max = end-1;
        int start = (int)Math.floor(Math.random()*(max-min+1)+min);
        if(isBoardEntityExists(start) || isBoardEntityExists(end)) return;
        BoardEntity boardEntity = new BoardEntity(start, end, BoardEntityType.LADDER);
        boardEntityMap.put(start, boardEntity);
    }

    public boolean isBoardEntityExists(int index) {
        if(boardEntityMap.containsKey(index)) {
            return true;
        }
        return false;
    }
}

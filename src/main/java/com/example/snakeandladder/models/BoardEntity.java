package com.example.snakeandladder.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardEntity {
    private int start, end;
    private BoardEntityType boardEntityType;
    public BoardEntity(int start, int end, BoardEntityType boardEntityType) {
        this.start = start;
        this.end = end;
        this.boardEntityType = boardEntityType;
    }
}

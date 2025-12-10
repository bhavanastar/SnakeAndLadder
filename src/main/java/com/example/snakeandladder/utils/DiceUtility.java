package com.example.snakeandladder.utils;

public class DiceUtility {
    public static int roll(int numDice) {
        int min = 1;
        int max = numDice*6;
        return (int)(Math.floor(Math.random()*(max-min+1)+min));
    }
}

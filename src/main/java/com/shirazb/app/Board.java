package com.shirazb.app;

import java.util.Arrays;

public class Board {
    private int[][] board = new int[3][3];

    public boolean isGameOver() {
        return true;
    }

    public void playMove(Move m) {

    }

    @Override
    public String toString() {
        return Arrays.toString(board);
    }

    public String result() {
        return "no results yet";
    }
}

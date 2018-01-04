package com.shirazb.app;

import com.shirazb.app.Player.Player;

import java.util.Arrays;

public class Board {
    private static final int X_DIM = 3;
    private static final int Y_DIM = 3;

    // TODO: Init to -1
    private int[][] board = new int[X_DIM][Y_DIM];
    private Player winner = null;
    private boolean isGameOver = false;

    public boolean isGameOver() {
        return this.isGameOver;
    }

    /**
     * Plays the given move by the player, affecting the board accordingly.
     * If the move results in the end of the game, isGameOver() will now
     * return true. result() will return the result of the game.
     * @param m The move to play.
     * @param p The player that is playing the move.
     */
    public void playMove(Move m, Player p) {
        /*
        The move m is a 2D-coordinate that indexes the board. To play the
        move is to set that position to the player's id.

        Will check if the move results in the game finishing. If so, sets
        isGameOver and winner.
         */
        // TODO: Check move valid, check player id valid
    }

    @Override
    public String toString() {
        return Arrays.toString(board);
    }

    public String result() {
        return "no results yet";
    }
}

package com.shirazb.app;

import com.shirazb.app.Player.Player;

import java.util.*;

public class Board {
    private static final int X_DIM = 3;
    private static final int Y_DIM = 3;

    /*
    The game board. Initialised to 0 and filled with player IDs in the
    positions they have made moves.
     */
    private int[][] board = new int[Y_DIM][X_DIM];

    /*
    The set of players playing on this board.
     */
    // TODO: Is this appropriate data structure
    private Map<Integer, Player> players = new HashMap<>();

    /*
    Initialised to null. playMove() may eventually set this to the winning
    player.
     */
    private Player winner = null;

    /*
    Initialised to false, eventually set to true by playMove() once it
    detects the game is over.
     */
    private boolean isGameOver = false;

    public boolean isGameOver() {
        return this.isGameOver;
    }

    public Board(Player... players) {
        Arrays.stream(players).forEach(
                p -> {
                    this.players.put(p.getId(), p);
                }
        );
    }

    /**
     * Plays the given move by the player, affecting the board accordingly.
     * If the move results in the end of the game, isGameOver() will now
     * return true. result() will return the result of the game.
     *
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
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < X_DIM; i++) {
            sb.append(" -");
        }

        sb.append(System.lineSeparator());

        for (int[] row : board) {
            sb.append('|');
            for (int pos : row) {
                sb.append(pos);
                sb.append('|');
            }
            sb.append(System.lineSeparator());
        }

        for (int i = 0; i < X_DIM; i++) {
            sb.append(" -");
        }

        return sb.toString();
    }

    public String result() {
        // TODO: Check that isGameOver
        return winner == null ? "Draw" : "Winner is " + winner.getName();
    }
}

package com.shirazb.app;

import com.shirazb.app.Player.Player;

import java.util.*;

public class Board {
    private static final int X_DIM = 3;
    private static final int Y_DIM = 3;

    public static int getxDim() {
        return X_DIM;
    }

    public static int getyDim() {
        return Y_DIM;
    }

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

    /*
    Iterated after each call to playMove(). Used to quickly check if there
    has been a draw by comparing to size of board (no spaces left).
     */
    private int playedMoves = 0;

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

        final int x = m.getX();
        final int y = m.getY();

        // Assert move is valid, as is already properly checked in mkMove().
        assert 0 <= x && x < Board.getxDim() &&
                0 <= y && y < Board.getyDim() :
                "playMove(): Invalid move: " + m;

        // Assert not given player that doesn't exist.
        assert players.containsKey(p.getId()) : "playMove(): Given player not" +
                " in set of players: " + p;

        // Assert that player ID is valid.
        assert 0 < p.getId() : "playMove(): Invalid player ID: " + p;

        board[y][x] = p.getId();

        // Check for draw.
        playedMoves += 1;
        if (playedMoves >= X_DIM * Y_DIM) {
            // Keep winner null, set game over.
            assert winner == null : "Board.playMove(): Draw detected but " +
                    "winner already set to: " + p;
            isGameOver = true;
            return;
        }

        // Check player p has won.
        if (hasWon(x, y, p.getId())) {
            isGameOver = true;
            winner = p;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Top row of dashses.
        for (int i = 0; i < X_DIM; i++) {
            sb.append(" -");
        }

        sb.append(System.lineSeparator());

        // For each row.
        for (int[] row : board) {
            // Start with left pipe.
            sb.append('|');
            // For each col position.
            for (int pos : row) {
                // Get player in that position by ID and print its symbol.
                Player p = players.get(pos);
                String symbol = p == null ? " " : p.getSymbol();
                sb.append(symbol);
                sb.append('|');
            }
            sb.append(System.lineSeparator());
        }

        // Bottom row of dashes.
        for (int i = 0; i < X_DIM; i++) {
            sb.append(" -");
        }

        return sb.toString();
    }

    public String result() {
        // TODO: Check that isGameOver
        return winner == null ? "Draw" : "Winner is " + winner.getName();
    }

    private boolean hasWon(int x, int y, int id) {
        assert 0 <= x && x < X_DIM;
        assert 0 <= y && y < Y_DIM;

        boolean won = true;
        // Check left-right direction.
        for (int i = 0; i < X_DIM; i++) {
            if (board[y][i] != id) {
                won = false;
                break;
            }
        }
        if (won) {
            return true;
        }

        // Check up-down direction.
        won = true;
        for (int i = 0; i < Y_DIM; i++) {
            if (board[i][x] != id) {
                won = false;
                break;
            }
        }
        if (won) {
            return true;
        }

        // Check top-left to bottom-right direction.
        // TODO: Does not check move was on diagonal. Assumes Square board.
        won = true;
        for (int i = 0; i < X_DIM; i++) {
            if (board[i][i] != id) {
                won = false;
                break;
            }
        }

        // Check bottom-left to top-right direction.
        won = true;
        for (int i = 0; i < X_DIM; i++) {
            if (board[Y_DIM - i - 1][i] != id) {
                won = false;
                break;
            }
        }

        return won;
    }
}

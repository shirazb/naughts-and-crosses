package com.shirazb.app;

import com.shirazb.app.Player.Human;
import com.shirazb.app.Player.Player;

public class Game {
    private Player human = new Human();
    private Player comp = new Human(); // For now
    private Board board = new Board();

    public void play() {
        System.out.println("Welcome to Os and Xs.");

        Player[] players = new Player[] { human, comp };
        final int numPlayers = players.length;

        for (int i = 0; board.isGameOver(); i = (i + 1) % numPlayers) {
            Player p = players[i];
            Move m = p.nextMove(board);
            board.playMove(m);
        }

        System.out.println("Result: " + board.result());
    }
}

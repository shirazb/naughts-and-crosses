package com.shirazb.app;

import com.shirazb.app.Player.Player;
import com.shirazb.app.Player.PlayerFactory;

public class Game {
    private Player human = PlayerFactory.human("Human", "O");
    private Player comp = PlayerFactory.human("human", "X"); // For now
    private Board board = new Board(human, comp);

    public void play() {
        System.out.println("Welcome to Os and Xs.");

        Player[] players = new Player[] { human, comp };
        final int numPlayers = players.length;

        for (int i = 0; !board.isGameOver(); i = (i + 1) % numPlayers) {
            Player p = players[i];
            Move m = p.nextMove(board);
            board.playMove(m, p);
            System.out.println(board);

            // FIXME
            break;
        }

        System.out.println("Result: " + board.result());
    }
}

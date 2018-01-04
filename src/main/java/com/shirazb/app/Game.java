package com.shirazb.app;

import com.shirazb.app.Player.Player;
import com.shirazb.app.Player.PlayerFactory;

public class Game {
    private Player playerOne = PlayerFactory.human("Human", "O");
    private Player playerTwo = PlayerFactory.human("Comp", "X"); // For now
    private Board board;

    public Game(int boardSize, String playerOneName, String playerTwoName) {
        this.playerOne = PlayerFactory.human(playerOneName, "O");
        this.playerTwo = PlayerFactory.human(playerTwoName, "X");
        this.board = new Board(boardSize, this.playerOne, this.playerTwo);
    }

    public void play() {
        System.out.println(board);

        Player[] players = new Player[] { playerOne, playerTwo };
        final int numPlayers = players.length;

        for (int i = 0; !board.isGameOver(); i = (i + 1) % numPlayers) {
            Player p = players[i];
            Move m = p.nextMove(board);
            board.playMove(m, p);
            System.out.println(board);
        }

        System.out.println("Result: " + board.result());
    }
}

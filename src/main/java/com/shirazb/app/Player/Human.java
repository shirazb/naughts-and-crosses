package com.shirazb.app.Player;

import com.shirazb.app.Board;
import com.shirazb.app.Move;

import java.util.Scanner;

public class Human implements Player {

    private final String name;
    private final String symbol;
    private final int id;

    public Human(String name, String symbol, int id) {
        this.symbol = symbol;
        this.name = name;

        assert id >= 0 : "new Human(): Invalid id: " + id;
        this.id = id;
    }

    public Move nextMove(Board b) {
        Move m;
        Scanner s = new Scanner(System.in);

        do {
            System.out.println("Please enter a move represented as \'<row> " +
                    "<col>\'");

            int x = s.nextInt();
            int y = s.nextInt();
            m = mkMove(x, y);
        } while (m == null);

        return m;
    }

    private Move mkMove(int x, int y) {
        return 0 <= x && x < Board.getxDim() && 0 <= y && y < Board.getyDim() ?
                new Move(x, y) :
                null;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }
}

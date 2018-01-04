package com.shirazb.app.Player;

import com.shirazb.app.Board;
import com.shirazb.app.Move;

import java.util.InputMismatchException;
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

    /**
     * Reads in two integers from the user, representing the co-ordinates of
     * their next move. Keeps asking for a move until the move is valid.
     * @param b The game board.
     * @return The next move as given by the user.
     */
    public Move nextMove(Board b) {
        Move m = null;
        Scanner s = new Scanner(System.in);

        do {
            System.out.println("Please enter a move represented as \'<row> " +
                    "<col>\'");

                int x;
                int y;

                if (s.hasNextInt()) {
                    x = s.nextInt();
                } else {
                    s.next();
                    continue;
                }

                if (s.hasNextInt()) {
                    y = s.nextInt();
                } else {
                    s.next();
                    continue;
                }

                m = mkMove(b, x, y);
        } while (m == null);

        return m;
    }

    private Move mkMove(Board b, int x, int y) {
        return 0 <= x && x < b.getxDim() && 0 <= y && y < b.getyDim() ?
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Human human = (Human) o;

        return id == human.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}

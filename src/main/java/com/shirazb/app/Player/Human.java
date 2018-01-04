package com.shirazb.app.Player;

import com.shirazb.app.Board;
import com.shirazb.app.Move;

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
        return new Move(0,0);
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }
}

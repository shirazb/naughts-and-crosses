package com.shirazb.app.Player;

import com.shirazb.app.Board;
import com.shirazb.app.Move;

public class Human implements Player {

    public Move nextMove(Board b) {
        return new Move(0,0);
    }
}

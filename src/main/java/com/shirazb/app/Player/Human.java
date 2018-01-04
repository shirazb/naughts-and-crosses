package com.shirazb.app.Player;

import com.shirazb.app.Move;

public class Human implements Player {

    public Move nextMove() {
        return new Move(0,0);
    }
}

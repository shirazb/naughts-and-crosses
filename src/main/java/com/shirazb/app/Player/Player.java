package com.shirazb.app.Player;

import com.shirazb.app.Board;
import com.shirazb.app.Move;

public interface Player {
    /**
     * Returns the next move of the player. May use the current state of the
     * board to calculate this.
     * @param b The game board.
     * @return The next move to play.
     */
    public Move nextMove(Board b);
    public int getId();
    public String getName();
    public String getSymbol();
}

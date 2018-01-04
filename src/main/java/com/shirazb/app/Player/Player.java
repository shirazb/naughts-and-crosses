package com.shirazb.app.Player;

import com.shirazb.app.Board;
import com.shirazb.app.Move;

public interface Player {
    public Move nextMove(Board b);
    public int getId();
    public String getName();
    public String getSymbol();
}

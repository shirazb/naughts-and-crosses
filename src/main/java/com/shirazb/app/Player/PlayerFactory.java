package com.shirazb.app.Player;

public class PlayerFactory {
    private static int nextId = 0;

    public static Player human(String name, String symbol) {
        return new Human(name, symbol, nextId++);
    }
}

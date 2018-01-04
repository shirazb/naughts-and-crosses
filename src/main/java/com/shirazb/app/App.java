package com.shirazb.app;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    private static final int DEFAULT_BOARD_SIZE = 3;

    private static int nameIdx = 1;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Os and Xs.\n");

        int boardSize = askForBoardSize();
        String playerOneName = askForName();
        String playerTwoName = askForName();

        new Game(boardSize, playerOneName, playerTwoName).play();
    }

    private static int askForBoardSize() {
        int boardSize = DEFAULT_BOARD_SIZE;
        System.out.println("Board Size as a single integer: ");
        if (scanner.hasNextInt()) {
            boardSize = scanner.nextInt();
        } else {
            scanner.next();
            System.out.println("Could not read, defaulting to " +
                    DEFAULT_BOARD_SIZE + "...");
        }

        if (boardSize < 3) {
            System.out.println("Too small, defaulting to " +
                    DEFAULT_BOARD_SIZE + "...");
            boardSize = DEFAULT_BOARD_SIZE;
        }

        return boardSize;
    }

    private static String askForName() {
        System.out.println("Name of player " + nameIdx++ + ":");
        // Looks stupid but needed for error handling.
        return scanner.hasNext() ? scanner.next() : scanner.next();
    }
}

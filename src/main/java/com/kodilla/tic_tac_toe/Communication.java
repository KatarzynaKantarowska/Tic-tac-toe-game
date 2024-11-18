package com.kodilla.tic_tac_toe;

import java.util.Scanner;

import static com.kodilla.tic_tac_toe.GameStatusEnum.*;

public class Communication {
    public static void main(String[] args) {
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome in tic-tac-toe game :)!");
        System.out.println("Would you like to play with friend? (Y/N)");
        boolean playWithFriend = scanner.nextLine().equalsIgnoreCase("Y");

        while (true) {
            game.print();
            System.out.println("Chose the field, by pick column number (0-2) and" +
                    " row number(0-2):");
            System.out.println("Chose the column:");
            int column = new Scanner(System.in).nextInt();
            System.out.println("Chose the row");
            int row = new Scanner(System.in).nextInt();

            if (row < 0 || row > 2 || column < 0 || column > 2) {
                System.out.println("Wrong coordinates! Try again!");
                continue;
            }
            try {
                game.makeMove(column, row);
            } catch (IllegalArgumentException e) {
                System.out.println("The field is unavailable! Try another one!");
                continue;
            }

            if (game.getState() == X || game.getState() == O) {
                game.print();
                System.out.println("Player " + (game.isXTurn() ? X : O) + " won! Congrats!");
                break;
            } else if (game.getState() == DRAW) {
                game.print();
                System.out.println("Draw : the board is full!");
            }
        }
        scanner.close();
    }
}
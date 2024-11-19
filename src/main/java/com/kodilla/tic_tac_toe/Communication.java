package com.kodilla.tic_tac_toe;

import java.util.Scanner;

import static com.kodilla.tic_tac_toe.CoordinateGenerator.makeCoordinateForAI;
import static com.kodilla.tic_tac_toe.CoordinateGenerator.makeCoordinateForUser;
import static com.kodilla.tic_tac_toe.GameStatusEnum.*;

public class Communication {
    public static void main(String[] args) {
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome in tic-tac-toe game :)!");
        System.out.println("Would you like to play with friend? (Y/N)");
        boolean playWithFriend = scanner.nextLine().equalsIgnoreCase("Y");


        int i = 0;
        while (true) {
            game.print();

            Coordinate coordinate = playWithFriend || i % 2 == 0 ? makeCoordinateForUser() : makeCoordinateForAI(game);

            int row = coordinate.getRow();
            int column = coordinate.getColumn();

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
                break;
            }
            i++;
        }
        scanner.close();
    }
}
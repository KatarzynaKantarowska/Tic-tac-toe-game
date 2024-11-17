package com.kodilla.tic_tac_toe;

import java.util.Scanner;

import static com.kodilla.tic_tac_toe.GameStatusEnum.*;

public class Communication {
    public static void main(String[] args) {
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome in tic-tac-toe game :)!");
        // System.out.println("Would you like to play with friend? (Y/N)");
        //boolean playWithFriend = scanner.nextLine().toUpperCase().equals("Y");

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
            game.makeMove(column, row);

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

//    static void computerMove(CharArray game) {
//    Random random = new Random();
//    int row, column;
//
//    while(true) {
//        row = random.nextInt(3);
//        column = random.nextInt(3);
//
//        if (game.putChar(column,row)){
//            break;
//            }
//        }
//    }

}
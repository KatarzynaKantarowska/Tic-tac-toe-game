package com.kodilla.tic_tac_toe;

import java.util.Random;
import java.util.Scanner;


public class CoordinateGenerator {

    public static Coordinate makeCoordinateForAI(Game game) {
        Random random = new Random();

        Coordinate computerCoordinate;
        while (true) {
            int row = random.nextInt(3);
            int column = random.nextInt(3);
            System.out.println("Computer coordinate: " + row + ", " + column);
            boolean result = Game.isFieldAvailable(row, column, game);
            if (result) {
                computerCoordinate = new Coordinate(row, column);
                break;
            }
        }
        return computerCoordinate;
    }

    public static Coordinate makeCoordinateForUser() {
        System.out.println("Chose the field, by pick column number (0-2) and row number(0-2):");
        System.out.println("Chose the column:");
        int column = new Scanner(System.in).nextInt();
        System.out.println("Chose the row");
        int row = new Scanner(System.in).nextInt();
        return new Coordinate(column, row);
    }

}

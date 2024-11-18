package com.kodilla.tic_tac_toe;

import java.util.Random;


public class ComputerCoordinateGenerator {

    public static Coordinate generate(Game game) {
        Random random = new Random();

        Coordinate computerCoordinate;
        while (true) {
            int row = random.nextInt(3);
            int column = random.nextInt(3);
            boolean result = Game.isFieldAvailable(row, column, game);
            if (result) {
                computerCoordinate = new Coordinate(row, column);
                break;
            }
        }
        return computerCoordinate;
    }

}

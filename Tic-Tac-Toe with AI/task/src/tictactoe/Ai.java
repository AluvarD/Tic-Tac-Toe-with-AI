package tictactoe;

import java.util.Random;

public class Ai {
    public static String generateCoordinatesAiEasy (char[][] table) {
        int x;
        int y;
        Random random = new Random();
        StringBuilder coordinateArray = new StringBuilder();
        do {
            x = random.nextInt(2 + 1);
            y = random.nextInt(2 + 1);
            x += 1;
            y += 1;
            //System.out.println("x: " + x + " y: " + y);
        } while (GameChecks.checkCoordinates(table, String.valueOf(x), String.valueOf(y)) != 0);
        //System.out.println("Final x: " + x + " Final y: " + y);
        coordinateArray.append(x).append(" ").append(y);
        return coordinateArray.toString();
    }
}

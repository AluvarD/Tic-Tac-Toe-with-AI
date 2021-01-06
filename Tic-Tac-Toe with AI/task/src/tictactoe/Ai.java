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
        } while (GameChecks.checkCoordinates(table, String.valueOf(x), String.valueOf(y)) != 0);
        coordinateArray.append(x).append(" ").append(y);
        return coordinateArray.toString();
    }

    public static String generateCoordinatesAiMedium (char[][] table) {
        int x;
        int y;
        Random random = new Random();
        StringBuilder coordinateArray = aiOpinionMedium(table);
        if (coordinateArray.length() == 0) {
            //System.out.println("Not move, generate");
            do {
                x = random.nextInt(2 + 1);
                y = random.nextInt(2 + 1);
                x += 1;
                y += 1;
            } while (GameChecks.checkCoordinates(table, String.valueOf(x), String.valueOf(y)) != 0);
            coordinateArray.append(x).append(" ").append(y);
        }
        //System.out.println(coordinateArray.toString());
        return coordinateArray.toString();
    }

    public static StringBuilder aiOpinionMedium (char[][] table) {
        StringBuilder aiMoveArray = new StringBuilder();
        if (table[0][0] != '_' && table[0][1] != '_' && table[0][2] == '_') { //horizontal check
            aiMoveArray.append(1).append(" ").append(3);
            return aiMoveArray;
        } else if (table[0][1] != '_' && table[0][2] != '_' && table[0][0] == '_') {
            aiMoveArray.append(1).append(" ").append(1);
            return aiMoveArray;
        } else if (table[0][0] != '_' && table[0][2] != '_' && table[0][1] == '_') {
            aiMoveArray.append(1).append(" ").append(2);
            return aiMoveArray;
        } else if (table[1][0] != '_' && table[1][1] != '_' && table[1][2] == '_') {
            aiMoveArray.append(2).append(" ").append(3);
            return aiMoveArray;
        } else if (table[1][1] != '_' && table[1][2] != '_' && table[1][0] == '_') {
            aiMoveArray.append(2).append(" ").append(1);
            return aiMoveArray;
        } else if (table[1][0] != '_' && table[1][2] != '_' && table[1][1] == '_') {
            aiMoveArray.append(2).append(" ").append(2);
            return aiMoveArray;
        } else if (table[2][0] != '_' && table[2][1] != '_' && table[2][2] == '_') {
            aiMoveArray.append(3).append(" ").append(3);
            return aiMoveArray;
        } else if (table[2][1] != '_' && table[2][2] != '_' && table[2][0] == '_') {
            aiMoveArray.append(3).append(" ").append(1);
            return aiMoveArray;
        } else if (table[2][0] != '_' && table[2][2] != '_' && table[2][1] == '_') {
            aiMoveArray.append(3).append(" ").append(2);
            return aiMoveArray;
        } else if (table[0][0] != '_' && table[1][0] != '_' && table[2][0] == '_') { //vertical check
            aiMoveArray.append(3).append(" ").append(1);
            return aiMoveArray;
        } else if (table[1][0] != '_' && table[2][0] != '_' && table[0][0] == '_') {
            aiMoveArray.append(1).append(" ").append(1);
            return aiMoveArray;
        } else if (table[0][0] != '_' && table[2][0] != '_' && table[1][0] == '_') {
            aiMoveArray.append(2).append(" ").append(1);
            return aiMoveArray;
        } else if (table[0][1] != '_' && table[1][1] != '_' && table[2][1] == '_') {
            aiMoveArray.append(3).append(" ").append(2);
            return aiMoveArray;
        } else if (table[1][1] != '_' && table[2][1] != '_' && table[0][1] == '_') {
            aiMoveArray.append(1).append(" ").append(2);
            return aiMoveArray;
        } else if (table[0][1] != '_' && table[2][1] != '_' && table[1][1] == '_') {
            aiMoveArray.append(2).append(" ").append(2);
            return aiMoveArray;
        } else if (table[0][2] != '_' && table[1][2] != '_' && table[2][2] == '_') {
            aiMoveArray.append(3).append(" ").append(3);
            return aiMoveArray;
        } else if (table[1][2] != '_' && table[2][2] != '_' && table[0][2] == '_') {
            aiMoveArray.append(1).append(" ").append(3);
            return aiMoveArray;
        } else if (table[0][2] != '_' && table[2][2] != '_' && table[1][2] == '_') {
            aiMoveArray.append(2).append(" ").append(3);
            return aiMoveArray;
        } else if (table[0][0] != '_' && table[1][1] != '_' && table[2][2] == '_') { //horizontal check
            aiMoveArray.append(3).append(" ").append(3);
            return aiMoveArray;
        } else if (table[1][1] != '_' && table[2][2] != '_' && table[0][0] == '_') {
            aiMoveArray.append(1).append(" ").append(1);
            return aiMoveArray;
        } else if (table[2][0] != '_' && table[1][1] != '_' && table[0][2] == '_') {
            aiMoveArray.append(1).append(" ").append(3);
            return aiMoveArray;
        } else if (table[1][1] != '_' && table[0][2] != '_' && table[2][0] == '_') {
            aiMoveArray.append(3).append(" ").append(1);
            return aiMoveArray;
        }

        return aiMoveArray;
    }
}

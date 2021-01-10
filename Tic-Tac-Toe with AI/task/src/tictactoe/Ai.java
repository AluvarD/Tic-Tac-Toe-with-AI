package tictactoe;

import java.util.Arrays;
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
        } else if (table[0][0] != '_' && table[1][1] != '_' && table[2][2] == '_') { //diagonal check
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

    public static String generateCoordinatesAiHard (char[][] table, char move) {
        int x;
        int y;
        Random random = new Random();
        StringBuilder coordinateArray = minimax(table, move);
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

    public static StringBuilder minimax (char[][] table, char move) {
        StringBuilder aiMoveArray = new StringBuilder();
        Integer[] emptyPlaces = emptyPlaces(table);
        //System.out.println(Arrays.toString(emptyPlaces));
        Integer[][] scoreArray = new Integer[9][3];
        int score;
        int k = 0;
        //System.out.println("Save table status: ");
        String tableTempLine = Table.saveTable(table);
        //System.out.println(tableTempLine);
        //System.out.println(emptyPlaces[0] + " " + emptyPlaces[1]);
        for (int i = 0; i + 1 < emptyPlaces.length; i += 2) {
            //System.out.println("Start minimax for position: " + emptyPlaces[i] + " " + emptyPlaces[i + 1]);
            //System.out.println("Init table: ");
            //Table.printTable(table);
            score = minimaxAlgorithm(table, move, emptyPlaces[i], emptyPlaces[i + 1]);

            //System.out.println("Get score for position: " + emptyPlaces[i] + " " + emptyPlaces[i + 1] + " score is: " + score);
            scoreArray[k][0] = emptyPlaces[i];
            scoreArray[k][1] = emptyPlaces[i + 1];
            scoreArray[k][2] = score;
            k++;

            Table.tableInit(table, tableTempLine);
        }
        /*System.out.println("Score array: ");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(scoreArray[i][j] + " ");
            }
            System.out.print("\n");
        }*/
        Table.tableInit(table, tableTempLine);
        //find max score
        int indexMax = 0;
        int indexMin = 0;
        int maxScore = 0;
        int minScore = 0;
        for (int i = 0; i < 9; i++) {
            if (scoreArray[i][2] == null){
                break;
            }
            if (scoreArray[i][2] > maxScore){
                maxScore = scoreArray[i][2];
                indexMax = i;
            }
            if (scoreArray[i][2] < minScore) {
                minScore = scoreArray[i][2];
                indexMin = i;
            }
        }
        //System.out.println("Max score in line: " + index);

        if (maxScore >= 10) {
            aiMoveArray.append(scoreArray[indexMax][0] + 1).append(" ").append(scoreArray[indexMax][1] + 1);
            //System.out.println("Coordinates is: " + aiMoveArray);
        } else if (minScore < 0) {
            aiMoveArray.append(scoreArray[indexMin][0] + 1).append(" ").append(scoreArray[indexMin][1] + 1);
        }

        return aiMoveArray;
    }
    
    public static Integer minimaxAlgorithm (char[][] table, char move, int x, int y) {
        int score = 0;
        int count = 0;
        char playerMove;
        //define payer move
        if (move == 'O') {
            playerMove = 'X';
        } else {
            playerMove = 'O';
        }

        Table.changeInTable(table, x + 1, y + 1, move);
        //define win ai or player for the next move
        if (winning(table, move)) {
            score += 10;
        } else if (winning(table, playerMove)){
            score += -10;
        } else {
            do {
                if(GameChecks.checkGameResult(table) != 0) {
                    break;
                }
                //System.out.println("Emulate player move: ");
                String playerCoordinates = generateCoordinatesAiMedium(table);

                String[] convertPlayer = playerCoordinates.split(" ");
                String[] inputArrayPlayer = {"0", "0"};

                for (int i = 0; i < convertPlayer.length; i++) {
                    inputArrayPlayer[i] = convertPlayer[i];
                }

                String xPlayer = inputArrayPlayer[0];
                String yPlayer = inputArrayPlayer[1];

                Table.changeInTable(table, Integer.parseInt(xPlayer), Integer.parseInt(yPlayer), playerMove);
                if(GameChecks.checkGameResult(table) != 0) {
                    break;
                }

                if (winning(table, move)) {
                    score += 10;
                    break;
                } else if (winning(table, playerMove)){
                    score += -10;
                    break;
                }
                //System.out.println("Score after " + count + " emulated user move: " + score + "\n");
                //Table.printTable(table);

                //System.out.println("Emulate ai move: ");
                String aiCoordinates = generateCoordinatesAiMedium(table);

                String[] convertAi = aiCoordinates.split(" ");
                String[] inputArrayAi = {"0", "0"};

                for (int i = 0; i < convertPlayer.length; i++) {
                    inputArrayAi[i] = convertAi[i];
                }

                String xAi = inputArrayAi[0];
                String yAi = inputArrayAi[1];

                Table.changeInTable(table, Integer.parseInt(xAi), Integer.parseInt(yAi), move);
                if(GameChecks.checkGameResult(table) != 0) {
                    break;
                }

                if (winning(table, move)) {
                    score += 10;
                    break;
                } else if (winning(table, playerMove)){
                    score += -10;
                    break;
                }
                //System.out.println("Score after " + count + " emulated ai move: " + score);
                //Table.printTable(table);
                count++;
            } while (GameChecks.checkGameResult(table) == 0);
        }
        return score;
    }

    public static boolean winning (char[][] table, char move) {
        return (table[0][0] == move && table[0][1] == move && table[0][2] == move) ||
                (table[1][0] == move && table[1][1] == move && table[1][2] == move) ||
                (table[2][0] == move && table[2][1] == move && table[2][2] == move) ||
                (table[0][0] == move && table[1][0] == move && table[2][0] == move) ||
                (table[0][1] == move && table[1][1] == move && table[2][1] == move) ||
                (table[0][2] == move && table[1][2] == move && table[2][2] == move) ||
                (table[0][0] == move && table[1][1] == move && table[2][2] == move) ||
                (table[2][0] == move && table[1][1] == move && table[0][2] == move);
    }

    public static Integer[] emptyPlaces (char[][] table) {
        Integer[] emptyPlaces = new Integer[0];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (table[i][j] == '_') {
                    emptyPlaces = Arrays.copyOf(emptyPlaces, emptyPlaces.length + 1);
                    emptyPlaces[emptyPlaces.length - 1] = i;
                    emptyPlaces = Arrays.copyOf(emptyPlaces, emptyPlaces.length + 1);
                    emptyPlaces[emptyPlaces.length - 1] = j;
                }
            }
        }
        return emptyPlaces;
    }
}

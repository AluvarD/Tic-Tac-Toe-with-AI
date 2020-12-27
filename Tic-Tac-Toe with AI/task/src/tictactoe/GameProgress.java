package tictactoe;

import java.util.Scanner;

public class GameProgress {

    public static void game (String mode) {
        char[][] table = new char[3][3];
        String startLine = "_________";

        Table.tableInit(table, startLine);
        Table.printTable(table);

        int move = 0;
        while (true) {
            move = GameChecks.checkTurn(table);
            String input = gameProcess(mode, move, table);

            String[] convert = input.split(" ");
            String[] inputArray = {"0", "0"};

            for (int i = 0; i < convert.length; i++) {
                inputArray[i] = convert[i];
            }

            String x = inputArray[0];
            String y = inputArray[1];

            if (GameChecks.checkCoordinates(table, x, y) == 2) {
                System.out.println("Coordinates should be from 1 to 3!");
            } else if (GameChecks.checkCoordinates(table, x, y) == 1) {
                System.out.println("You should enter numbers!");
            } else if (GameChecks.checkCoordinates(table, x, y) == 3) {
                System.out.println("This cell is occupied! Choose another one!");
            } else {
                Table.changeInTable(table, Integer.parseInt(x), Integer.parseInt(y), move);
                Table.printTable(table);
            }

            int result = GameChecks.checkGameResult(table);
            if (result == 1) {
                System.out.println("X wins");
                break;
            } else if (result == 2) {
                System.out.println("O wins");
                break;
            } else if (result == 3) {
                System.out.println("Draw");
                break;
            }
        }
    }

    public static String gameProcess (String mode, int move, char[][] table) {
        Scanner scanner = new Scanner(System.in);
        String input = new String();
        switch (mode) {
            case "aiVUserEasy":
                if (move == 0) {
                    System.out.print("Enter the coordinates: > ");
                    input = scanner.nextLine();
                } else if (move == 1) {
                    System.out.print("Making move level \"easy\"\n");
                    input = Ai.generateCoordinatesAiEasy(table);
                }
                break;
            case "aiVAiEasy":
                if (move == 0) {
                    System.out.print("Making move level \"easy\"\n");
                    input = Ai.generateCoordinatesAiEasy(table);
                } else if (move == 1) {
                    System.out.print("Making move level \"easy\"\n");
                    input = Ai.generateCoordinatesAiEasy(table);
                }
                break;
            case "pVp":
                if (move == 0) {
                    System.out.print("Enter the coordinates: > ");
                    input = scanner.nextLine();
                } else if (move == 1) {
                    System.out.print("Enter the coordinates: > ");
                    input = scanner.nextLine();
                }
                break;
        }
        return input;
    }
}

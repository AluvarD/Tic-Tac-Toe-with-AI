package tictactoe;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        String mode;
        while (true) {
            mode = mode();
            if (mode.equals("exit")) {
                break;
            }
            game(mode);
        }
    }

    public static String mode () {
        Scanner scanner = new Scanner(System.in);
        String input;
        String mode = "exit";
        boolean checkInput = false;

        do {
            System.out.print("Input command: > ");
            input = scanner.nextLine();
            switch (input) {
                case "start easy easy":
                    checkInput = true;
                    mode = "aiVAiEasy";
                    break;
                case "start easy user":
                    checkInput = true;
                    mode = "aiVUserEasy";
                    break;
                case "start user user":
                    checkInput = true;
                    mode = "pVp";
                    break;
                case "exit":
                    checkInput = true;
                    break;
                default:
                    System.out.println("Bad parameters!");
                    break;
            }
        } while (!checkInput);
        return mode;
    }

    public static void game (String mode) {
        char[][] table = new char[3][3];
        String startLine = "_________";

        tableInit(table, startLine);
        printTable(table);

        int move = 0;
        while (true) {
            move = checkTurn(table);
            String input = gameProcess(mode, move, table);

            String[] convert = input.split(" ");
            String[] inputArray = {"0", "0"};

            for (int i = 0; i < convert.length; i++) {
                inputArray[i] = convert[i];
            }

            String x = inputArray[0];
            String y = inputArray[1];

            if (checkCoordinates(table, x, y) == 2) {
                System.out.println("Coordinates should be from 1 to 3!");
            } else if (checkCoordinates(table, x, y) == 1) {
                System.out.println("You should enter numbers!");
            } else if (checkCoordinates(table, x, y) == 3) {
                System.out.println("This cell is occupied! Choose another one!");
            } else {
                changeInTable(table, Integer.parseInt(x), Integer.parseInt(y), move);
                printTable(table);
            }

            int result = checkGameResult(table);
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
                    input = generateCoordinatesAi(table);
                }
                break;
            case "aiVAiEasy":
                if (move == 0) {
                    System.out.print("Making move level \"easy\"\n");
                    input = generateCoordinatesAi(table);
                } else if (move == 1) {
                    System.out.print("Making move level \"easy\"\n");
                    input = generateCoordinatesAi(table);
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

    public static int checkTurn (char[][] table) {
        int xCount = 0;
        int oCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (table[i][j] == 'X') {
                    xCount++;
                } else if (table[i][j] == 'O'){
                    oCount++;
                }
            }
        }
        if (xCount > oCount) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void tableInit (char[][] table, String startLine) {
        int stringIndex = 0;
        char[] startLineArray = startLine.toCharArray();
        for (int i = 0; i < 3; i ++) {
            for (int j = 0; j < 3; j ++) {
                table[i][j] = startLineArray[stringIndex];
                stringIndex++;
            }
        }
    }

    public static void printTable (char[][] table) {
        System.out.println("---------");
        System.out.print("| ");
        for (int i = 0; i < 3; i++) {
            if (table[0][i] == '_') {
                System.out.print("  ");
            } else {
                System.out.print(table[0][i] + " ");
            }
        }
        System.out.println("|");
        System.out.print("| ");
        for (int i = 0; i < 3; i++) {
            if (table[1][i] == '_') {
                System.out.print("  ");
            } else {
                System.out.print(table[1][i] + " ");
            }
        }
        System.out.println("|");
        System.out.print("| ");
        for (int i = 0; i < 3; i++) {
            if (table[2][i] == '_') {
                System.out.print("  ");
            } else {
                System.out.print(table[2][i] + " ");
            }
        }
        System.out.println("|");
        System.out.println("---------");
    }

    public static void changeInTable (char[][] table, int x, int y, int move) {
        if (move % 2 == 0) {
            table[x - 1][y - 1] = 'X';
        } else {
            table[x - 1][y - 1] = 'O';
        }
    }

    /*public static void changeInTableAi (char[][] table, int move) {
        int x;
        int y;
        Random random = new Random();
        do {
            x = random.nextInt(3);
            y = random.nextInt(3);
        } while (checkCoordinates(table, String.valueOf(x), String.valueOf(y)) != 0);
        if (move % 2 == 0) {
            table[x][y] = 'X';
        } else {
            table[x][y] = 'O';
        }
    }*/
    
    public static String generateCoordinatesAi (char[][] table) {
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
        } while (checkCoordinates(table, String.valueOf(x), String.valueOf(y)) != 0);
        //System.out.println("Final x: " + x + " Final y: " + y);
        coordinateArray.append(x).append(" ").append(y);
        return coordinateArray.toString();
    }

    public static int checkCoordinates (char[][] table, String x, String y) {
        if (!checkString(x) || !checkString(y)) {
            return 1;
        } else if (Integer.parseInt(x) > 3 || Integer.parseInt(y) > 3){
            return 2;
        } else if (table[Integer.parseInt(x) - 1][Integer.parseInt(y) - 1] == 'X' || table[Integer.parseInt(x) - 1][Integer.parseInt(y) - 1] == 'O') {
            return 3;
        }
        return 0;
    }

    public static int checkGameResult (char[][] table) {
        int result = 0;

        for (int i = 0; i < 3; i++) {
            if (checkVertical(table, i, 'X')) {
                result = 1;
                break;
            } else if (checkHorizontal(table, i, 'X')) {
                result = 1;
                break;
            } else if (checkVertical(table, i, 'O')) {
                result = 2;
                break;
            } else if (checkHorizontal(table, i, 'O')) {
                result = 2;
                break;
            }
        }

        if (result == 0) {
            if (checkDiagonal(table, 'X')) {
                result = 1;
            } else if (checkDiagonal(table, 'O')) {
                result = 2;
            } else if (drawCheck(table)) {
                result = 3;
            }
        }
        return result;
    }

    public static boolean checkVertical (char[][] table, int vertical, char value) {
        if (table[0][vertical] == value && table[1][vertical] == value && table[2][vertical] == value) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkHorizontal (char[][] table, int horizontal, char value) {
        if (table[horizontal][0] == value && table[horizontal][1] == value && table[horizontal][2] == value) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkDiagonal (char[][] table, char value) {
        if (table[0][0] == value && table[1][1] == value && table[2][2] == value) {
            return true;
        } else if (table[2][0] == value && table[1][1] == value && table[0][2] == value) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean drawCheck (char[][] table) {
        int hollowPlace = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (table[i][j] == '_') {
                    hollowPlace++;
                }
            }
        }
        if (hollowPlace == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkString(String string) {
        if (string == null || string.length() == 0) return false;

        int i = 0;
        if (string.charAt(0) == '-') {
            if (string.length() == 1) {
                return false;
            }
            i = 1;
        }

        char c;
        for (; i < string.length(); i++) {
            c = string.charAt(i);
            if (!(c >= '0' && c <= '9')) {
                return false;
            }
        }
        return true;
    }
}

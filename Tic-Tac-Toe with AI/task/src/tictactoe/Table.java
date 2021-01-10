package tictactoe;

public class Table {

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

    public static String saveTable (char[][] table) {
        StringBuilder saveLine = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (table[i][j] == 'X') {
                    saveLine.append("X");
                } else if (table[i][j] == 'O') {
                    saveLine.append("O");
                } else {
                    saveLine.append("_");
                }
            }
        }

        return String.valueOf(saveLine);
    }
}

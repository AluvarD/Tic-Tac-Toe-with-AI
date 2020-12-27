package tictactoe;

public class GameChecks {
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
}

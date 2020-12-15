import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        char[][] matrix = new char[4][4];
        char[] input1 = scanner.next().toCharArray();
        char[] input2 = scanner.next().toCharArray();
        char[] input3 = scanner.next().toCharArray();
        char[] input4 = scanner.next().toCharArray();
        boolean result = true;

        System.arraycopy(input1, 0, matrix[0], 0, input1.length);
        System.arraycopy(input2, 0, matrix[1], 0, input2.length);
        System.arraycopy(input3, 0, matrix[2], 0, input3.length);
        System.arraycopy(input4, 0, matrix[3], 0, input4.length);

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix.length - 1; j++) {
                if (!checkMatrix(i, j, matrix)) {
                    result = false;
                    break;
                }
            }
        }

        if (result) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static boolean checkMatrix (int x, int y, char[][] matrix) {
        if (matrix[x][y] == matrix[x][y + 1] && matrix[x + 1][y] == matrix[x + 1][y + 1] && matrix[x][y] == matrix[x + 1][y] && matrix[x][y + 1] == matrix[x + 1][y + 1]) {
            return false;
        }
        return true;
    }
}
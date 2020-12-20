import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] hall = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++) {
                hall[i][j] = scanner.nextInt();
                //System.out.println("input in row: " + i + " position: " + j);
            }
        }
        int k = scanner.nextInt();
        int result = checkPlaces(hall, k, n, m);
        //System.out.println("\nresult");

        System.out.println(result);
    }

    public static int checkPlaces(int[][] hall, int k, int n, int m) {
        int result = 0;
        int breakFlag = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (count == k) {
                result = i;
                break;
            }
            count = 0;
            int temp = hall[i][0];
            if (temp == 0) {
                count++;
                //System.out.println("in row " + i + " first number 0, improve count to " + count);
            }
            if (breakFlag == 1) {
                break;
            }
            for (int j = 0; j < m - 1; j++) {
                //System.out.println("check " + i + " row, count is " + count);
                //System.out.println("temp: " + temp + " row + 1: " + hall[i][j + 1]);
                //System.out.println("check count: " + count + " with k: " + k);
                if (count == k) {
                    result = i + 1;
                    breakFlag = 1;
                    break;
                } else if (hall[i][j + 1] == 0) {
                    temp = hall[i][j + 1];
                    count++;
                    //System.out.println("improve count to " + count);
                } else if (temp == 0 && hall[i][j + 1] == 1){
                    temp = hall[i][j + 1];
                    count = 0;
                }
            }
        }

        if (count == k && result == 0) {
            result = n;
        }
        return result;
    }
}
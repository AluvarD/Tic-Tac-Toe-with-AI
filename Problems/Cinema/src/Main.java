import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] hall = fillHall(n, m);
        //for (int[] place : hall) {
        //    System.out.println(Arrays.toString(place));
        //}
        int k = scanner.nextInt();
        int result = checkPlaces(hall, k, n, m);
        //System.out.println("\nresult");
        if (result == 0) {
            System.out.println(result);
        } else {
            System.out.println(result + 1);
        }
    }

    public static int[][] fillHall(int n, int m) {
        Scanner input = new Scanner(System.in);
        int[][] hall = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++) {
                hall[i][j] = input.nextInt();
                //System.out.println("input in row: " + i + " position: " + j);
            }
        }
        return hall;
    }

    public static int checkPlaces(int[][] hall, int k, int n, int m) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            int temp = hall[i][0];
            if (temp == 0) {
                count++;
                //System.out.println("in row " + i + " first number 0, improve count to " + count);
            }
            for (int j = 0; j < m - 1; j++) {
                //System.out.println("check " + i + " row, count is " + count);
                //System.out.println("temp: " + temp + " row + 1: " + hall[i][j + 1]);
                if (hall[i][j + 1] == 0) {
                    temp = hall[i][j + 1];
                    count++;
                    //System.out.println("improve count to " + count);
                } else if (temp == 0 && hall[i][j + 1] == 1){
                    temp = hall[i][j + 1];
                }
                //System.out.println("check count: " + count + " with k: " + k);
                if (count == k) {
                    result = i;
                    break;
                }
            }
        }

        return result;
    }
}
import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] array = decomposition(n, n, "", new String[0]);

        for (int i = array.length - 1; i >= 0 ; i--) {
            System.out.println(array[i]);
        }
    }

    public static String[] decomposition(int n, int m, String p, String[] array) {
        if (n == 0) {
            array = Arrays.copyOf(array, array.length + 1);
            array[array.length - 1] = p;
            return array;
        }
        for (int i = Math.min(m, n); i >= 1; i--) {
            array = decomposition(n - i, i, p + i + " ", array);
        }

        return array;
    }
}
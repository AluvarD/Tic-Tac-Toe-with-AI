import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] companyArray = new int[n];
        int[] taxArray = new int[n];
        for (int i = 0; i < n; i++) {
            companyArray[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            taxArray[i] = scanner.nextInt();
        }
        int maxIndex = 0;
        for (int i = 1; i < n; i++) {
            if ((double) companyArray[maxIndex] * (double) taxArray[maxIndex] / 100 < (double) companyArray[i] * (double) taxArray[i] / 100) {
                maxIndex = i;
            }
        }
        System.out.println(maxIndex + 1);
    }
}
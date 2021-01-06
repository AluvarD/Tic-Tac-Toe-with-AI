package tictactoe;

import java.util.Scanner;

public class GameMode {
    public static String mode() {
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
                    mode = "aiVsAiEasy";
                    break;
                case "start easy user":
                    checkInput = true;
                    mode = "aiVsUserEasy";
                    break;
                case "start user easy":
                    checkInput = true;
                    mode = "userVsAiEasy";
                    break;
                case "start user medium":
                    checkInput = true;
                    mode = "userVsAiMedium";
                    break;
                case "star medium user":
                    checkInput = true;
                    mode = "aiVsUserMedium";
                    break;
                case "start medium medium":
                    checkInput = true;
                    mode = "aiVsAiMedium";
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
}

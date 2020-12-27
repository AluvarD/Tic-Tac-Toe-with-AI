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
}

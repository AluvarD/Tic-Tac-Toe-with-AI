package tictactoe;

public class Main {
    public static void main(String[] args) {
        // write your code here
        String mode;
        while (true) {
            mode = GameMode.mode();
            if (mode.equals("exit")) {
                break;
            }
            GameProgress.game(mode);
        }
    }
}

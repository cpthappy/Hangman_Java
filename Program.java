import java.io.IOException;

public class Program {
    public static void main(String[] args) {
        try {
            Game game = new Game();
            game.runGame();
        } catch (IOException ex) {
            System.out.println("Wörterliste nicht gefunden! ");
        }
    }

}
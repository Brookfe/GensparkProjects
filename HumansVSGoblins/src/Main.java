import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        Game play = new Game( rand );
        play.init();
    }
}
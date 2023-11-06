package lotto;

import java.util.List;
import java.util.stream.IntStream;
import lotto.view.Output;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();

        game.startGame();
    }
}

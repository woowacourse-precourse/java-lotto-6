package lotto;

import lotto.service.Game;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        game.run();
    }
}

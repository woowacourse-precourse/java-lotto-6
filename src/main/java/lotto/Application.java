package lotto;

import lotto.controller.Game;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
        game.finish();
    }
}

package lotto;

import lotto.config.Config;
import lotto.game.Game;

public class Application {
    public static void main(String[] args) {
        Config config = new Config();
        Game game = config.getLottoGame();
        game.play();
    }
}

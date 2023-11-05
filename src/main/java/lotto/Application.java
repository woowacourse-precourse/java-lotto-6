package lotto;

import lotto.config.AppConfig;
import lotto.game.Game;

public class Application {
    private static final AppConfig appConfig = new AppConfig();

    public static void main(String[] args) {
        Game game = appConfig.game();
        game.playLotto();
    }
}

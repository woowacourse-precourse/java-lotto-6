package lotto;

import lotto.config.AppConfig;
import lotto.game.Game;

public class Application {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        Game game = appConfig.game();
        game.playLotto();
    }
}

package lotto;

import lotto.configuration.AppConfig;
import lotto.controller.GameController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        AppConfig appConfig = new AppConfig();
        GameController gameController = appConfig.gameController();
        gameController.play();
    }
}

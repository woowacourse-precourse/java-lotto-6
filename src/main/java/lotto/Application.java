package lotto;

import lotto.config.ApplicationConfig;
import lotto.controller.LottoGameController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ApplicationConfig config = new ApplicationConfig();
        LottoGameController gameController = config.gameController();
        gameController.start();
    }

}

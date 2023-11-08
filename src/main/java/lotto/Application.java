package lotto;

import lotto.config.LottoConfig;
import lotto.controller.GameController;

public class Application {
    public static void main(String[] args) {
        LottoConfig lottoConfig = new LottoConfig();
        GameController gameController = lottoConfig.getGameController();
        gameController.start();
    }
}

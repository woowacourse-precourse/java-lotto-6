package lotto;

import lotto.controller.LottoGameController;
import lotto.util.AppConfig;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = AppConfig.getInstance();
        LottoGameController lottoGameController = appConfig.lottoGameController();
        LottoGame lottoGame = new LottoGame(lottoGameController);
        lottoGame.start();
    }
}

package lotto;

import lotto.config.AppConfig;
import lotto.controller.LottoGameController;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        LottoGameController lottoGameController = new LottoGameController(
                appConfig.inputView(),
                appConfig.outputView(),
                appConfig.profitRateCalculator(),
                appConfig.numberGenerator());
        lottoGameController.run();
    }
}

package lotto;

import lotto.configuration.AppConfig;
import lotto.configuration.Config;
import lotto.controller.LottoGameController;

public class Application {
    public static void main(String[] args) {
        Config config = generateConfig();
        LottoGameController lottoGameController = generateRacingController(config);
        lottoGameController.playGame();
    }

    private static Config generateConfig() {
        return AppConfig.getInstance();
    }

    private static LottoGameController generateRacingController(Config config) {
        return config.lottoGameController();
    }
}

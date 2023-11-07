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

// TODO: final달기, 테스트에 중복되는 내용 처리
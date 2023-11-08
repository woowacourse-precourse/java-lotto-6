package lotto;

import lotto.configuration.ApplicationConfiguration;
import lotto.controller.LottoGameController;

public class Application {
    public static void main(String[] args) {
        ApplicationConfiguration applicationConfiguration = new ApplicationConfiguration();
        LottoGameController lottoGameController = applicationConfiguration.lottoGameController();
        lottoGameController.gameStart();
    }
}

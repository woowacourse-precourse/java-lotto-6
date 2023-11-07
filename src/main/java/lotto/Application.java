package lotto;

import lotto.config.AppConfig;
import lotto.controller.LottoGameController;

public class Application {
    public static void main(String[] args) {
        LottoGameController lottoGameController = new LottoGameController(new AppConfig());
        lottoGameController.run();
    }
}

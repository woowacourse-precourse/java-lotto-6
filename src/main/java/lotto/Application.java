package lotto;

import lotto.config.AppConfig;

public class Application {
    public static void main(String[] args) {
        LottoGameController lottoGameController = new LottoGameController(new AppConfig());
        lottoGameController.run();
    }
}

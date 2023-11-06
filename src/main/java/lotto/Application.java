package lotto;

import lotto.controller.LottoGameController;

public class Application {
    public static void main(String[] args) {
        ApplicationConfig appConfig = new ApplicationConfig();
        LottoGameController lottoGameController = new LottoGameController(appConfig);
        lottoGameController.run();
    }
}

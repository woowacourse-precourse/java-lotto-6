package lotto;

import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        AppConfig config = new AppConfig();
        LottoController lottoController = config.setSystem();
        lottoController.run();
    }
}

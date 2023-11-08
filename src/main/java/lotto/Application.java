package lotto;

import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        LottoController lottosController = appConfig.lottosController();
        lottosController.run();
    }
}

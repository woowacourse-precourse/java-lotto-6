package lotto;

import lotto.configuration.AppConfig;
import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = AppConfig.getInstance();
        LottoController lottoController = appConfig.lottoController();
        lottoController.play();
    }
}

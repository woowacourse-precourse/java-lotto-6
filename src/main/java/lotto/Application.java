package lotto;

import lotto.config.ApplicationConfig;
import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = ApplicationConfig.controller;
        lottoController.purchaseLotto();
        lottoController.getAnswer();
    }
}

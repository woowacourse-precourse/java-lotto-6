package lotto;

import lotto.config.Configuration;
import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = Configuration.lottoController();

        lottoController.run();
    }
}

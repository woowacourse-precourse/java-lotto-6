package lotto;

import lotto.config.LottoConfig;
import lotto.controller.LottoController;

public class Application {

    public static void main(String[] args) {
        LottoController lottoController = LottoConfig.getLottoController();
        lottoController.run();
    }
}

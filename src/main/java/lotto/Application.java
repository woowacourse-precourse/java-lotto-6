package lotto;

import lotto.common.config.LottoConfig;
import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoConfig().getLottoController();
        lottoController.run();
    }
}

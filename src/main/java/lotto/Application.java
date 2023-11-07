package lotto;

import lotto.common.config.LottoConfig;
import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoConfig lottoConfig = new LottoConfig();

        LottoController lottoController = new LottoController(lottoConfig);
        lottoController.play();
    }
}

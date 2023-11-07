package lotto;

import lotto.config.GeneralLottoConfig;
import lotto.config.LottoConfig;
import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoConfig lottoConfig = new GeneralLottoConfig();
        LottoController lottoController = lottoConfig.lottoController();
        lottoController.run();
    }
}
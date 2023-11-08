package lotto;

import lotto.config.LottoApplicationConfig;
import lotto.controller.LottoController;

public class Application {

    public static void main(String[] args) {
        LottoApplicationConfig lottoApplicationConfig = new LottoApplicationConfig();
        LottoController lottoController = new LottoController(
                lottoApplicationConfig.createLottoService(),
                lottoApplicationConfig.createWinningService()
        );
        lottoController.run();
    }
}

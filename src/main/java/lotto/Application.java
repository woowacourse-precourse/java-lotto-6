package lotto;

import lotto.common.Config;
import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = Config.getLottoController();
        lottoController.run();
    }
}

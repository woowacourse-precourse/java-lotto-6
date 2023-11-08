package lotto;

import lotto.common.LottoControllerFactory;
import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoControllerFactory().getLottoController();
        lottoController.run();
    }
}

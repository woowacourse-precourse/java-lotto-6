package lotto;

import lotto.Controller.LottoController;
import lotto.DiContainer.DiContainer;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = DiContainer.of().getLottoController();
        lottoController.startProcess();
    }
}

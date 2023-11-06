package lotto;

import lotto.controller.LottoController;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.View;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(
                new View(new InputView(), new OutputView()));
        lottoController.run();
    }
}

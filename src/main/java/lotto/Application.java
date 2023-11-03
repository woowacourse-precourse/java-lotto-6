package lotto;

import lotto.controller.LottoController;
import lotto.view.console.InputView;
import lotto.view.console.OutputView;

public class Application {
    public static void main(String[] args) {
        new LottoController(
                new InputView(),
                new OutputView()
        ).run();
    }
}

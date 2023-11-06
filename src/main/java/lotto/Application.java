package lotto;

import lotto.controller.LottoController;
import lotto.generator.RandomNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new InputView(), new OutputView(),
                new RandomNumberGenerator());
        lottoController.run();
    }
}

package lotto;

import lotto.controller.LottoController;
import lotto.domain.RandomNumbersGenerator;
import lotto.view.ExceptionView;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new InputView(), new ExceptionView(),
                new OutputView(), new RandomNumbersGenerator());

        lottoController.lottoRun();
    }
}

package lotto;

import lotto.application.LottoMachine;
import lotto.application.RandomNumberGenerator;
import lotto.controller.LottoController;
import lotto.ui.InputView;
import lotto.ui.OutputView;
import lotto.validator.InputValidator;

public class Application {
    public static void main(String[] args) {
        final InputView inputView = new InputView(new InputValidator());
        final OutputView outputView = new OutputView();
        final LottoMachine lottoMachine = new LottoMachine(new RandomNumberGenerator());
        final LottoController lottoController = new LottoController(inputView, outputView, lottoMachine);

        lottoController.run();
    }
}

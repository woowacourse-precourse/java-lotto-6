package lotto;

import lotto.controller.LottoController;
import lotto.view.InputView;
import lotto.view.InputViewImplementation;
import lotto.view.OutputView;
import lotto.view.OutputViewImplementation;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputViewImplementation();
        OutputView outputView = new OutputViewImplementation();

        LottoController lottoController = new LottoController(inputView, outputView);
        lottoController.run();
    }
}

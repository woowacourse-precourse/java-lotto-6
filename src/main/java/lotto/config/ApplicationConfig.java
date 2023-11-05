package lotto.config;

import lotto.controller.LottoGameController;
import lotto.view.InputView;
import lotto.view.OutputView;

public class ApplicationConfig {

    public LottoGameController gameController() {
        return new LottoGameController(outputView(), inputView());
    }

    private OutputView outputView() {
        return new OutputView();
    }

    private InputView inputView() {
        return new InputView();
    }
}

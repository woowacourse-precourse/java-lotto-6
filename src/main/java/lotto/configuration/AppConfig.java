package lotto.configuration;

import lotto.controller.GameController;
import lotto.domain.NumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {

    private InputView inputView() {
        return new InputView();
    }

    private OutputView outputView() {
        return new OutputView();
    }

    private NumberGenerator numberGenerator() {
        return new NumberGenerator();
    }

    public GameController gameController() {
        return new GameController(inputView(), outputView(), numberGenerator());
    }

}

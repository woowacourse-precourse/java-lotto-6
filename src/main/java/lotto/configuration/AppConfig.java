package lotto.configuration;

import lotto.NumberGenerator;
import lotto.controller.GameController;
import lotto.controller.MoneyController;
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

    private MoneyController moneyController() {
        return new MoneyController();
    }

    public GameController gameController() {
        return new GameController(inputView(), outputView(), numberGenerator(), moneyController());
    }

}

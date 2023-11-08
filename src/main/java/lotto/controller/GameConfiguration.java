package lotto.controller;

import lotto.service.GameService;
import lotto.util.InputValueChecker;
import lotto.util.LottoNumberFactory;
import lotto.util.NumberFactory;
import lotto.view.input.ConsoleInput;
import lotto.view.input.Input;
import lotto.view.input.InputView;
import lotto.view.output.ConsoleOutputView;
import lotto.view.output.OutputView;

public class GameConfiguration {
    public GameController gameController() {
        return new GameController(outputView(), inputView(), gameService());
    }

    private OutputView outputView() {
        return new ConsoleOutputView();
    }

    private InputView inputView() {
        return new InputView(input(), inputValueChecker());
    }

    private Input input() {
        return new ConsoleInput();
    }

    private InputValueChecker inputValueChecker() {
        return new InputValueChecker();
    }

    private GameService gameService() {
        return new GameService(numberFactory());
    }

    private NumberFactory numberFactory() {
        return new LottoNumberFactory();
    }
}

package lotto.config;

import lotto.controller.FactoryController;
import lotto.controller.LottoController;
import lotto.view.input.ConsoleInputView;
import lotto.view.input.InputView;
import lotto.view.output.ConsoleOutputView;
import lotto.view.output.OutputView;

public class AppConfig {

    private InputView inputView() {
        return new ConsoleInputView();
    }

    private OutputView outputView() {
        return new ConsoleOutputView();
    }

    public FactoryController factoryController() {
        return new FactoryController(inputView(), outputView());
    }

    public LottoController lottoController() {
        return new LottoController(outputView(), factoryController());
    }
}

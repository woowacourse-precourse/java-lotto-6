package lotto.factory;

import lotto.controller.LottoController;
import lotto.io.InputManager;
import lotto.io.InputMapper;
import lotto.io.InputValidator;
import lotto.io.InputView;
import lotto.io.OutputView;

public class ComponentFactory {

    public LottoController lottoController() {
        return new LottoController(outputView(), inputManager());
    }

    private OutputView outputView() {
        return new OutputView();
    }

    private InputManager inputManager() {
        return new InputManager(inputView(), inputMapper());
    }

    private InputView inputView() {
        return new InputView(inputValidator());
    }

    private InputMapper inputMapper() {
        return new InputMapper();
    }

    private InputValidator inputValidator() {
        return new InputValidator();
    }
}

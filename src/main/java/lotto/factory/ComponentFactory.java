package lotto.factory;

import lotto.controller.LottoController;
import lotto.io.InputManager;
import lotto.io.InputMapper;
import lotto.io.InputValidator;
import lotto.io.InputView;
import lotto.io.OutputFommatter;
import lotto.io.OutputView;
import lotto.service.LottoService;
import lotto.utils.RandomNumberGenerator;

public class ComponentFactory {

    public LottoController lottoController() {
        return new LottoController(outputView(), inputManager(), lottoService());
    }

    private OutputView outputView() {
        return new OutputView(outputFommatter());
    }

    private OutputFommatter outputFommatter() {
        return new OutputFommatter();
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

    private LottoService lottoService() {
        return new LottoService(randomNumberGenerator());
    }

    private RandomNumberGenerator randomNumberGenerator() {
        return new RandomNumberGenerator();
    }
}

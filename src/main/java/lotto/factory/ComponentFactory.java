package lotto.factory;

import lotto.controller.LottoController;
import lotto.io.input.InputManager;
import lotto.io.input.InputMapper;
import lotto.io.input.InputValidator;
import lotto.io.input.InputView;
import lotto.io.output.OutputFommatter;
import lotto.io.output.OutputView;
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

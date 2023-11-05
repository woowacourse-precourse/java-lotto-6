package lotto.factory;

import lotto.controller.LottoController;
import lotto.formatter.OutputFormatter;
import lotto.io.InputManager;
import lotto.io.InputMapper;
import lotto.io.InputValidator;
import lotto.io.InputView;
import lotto.io.OutputView;
import lotto.repository.DomainRepository;
import lotto.service.LottoService;
import lotto.utils.LottoPublisher;

public enum ComponentFactory {
    INSTANCE;
    private final LottoController lottoController;

    ComponentFactory() {
        this.lottoController = new LottoController(outputView(), inputManager(), lottoService());
    }

    public LottoController lottoController() {
        return this.lottoController;
    }

    private LottoService lottoService() {
        return new LottoService(purchaseAmountRepository(), lottoPublisher());
    }

    private LottoPublisher lottoPublisher() {
        return new LottoPublisher();
    }

    private DomainRepository purchaseAmountRepository() {
        return new DomainRepository();
    }

    private InputManager inputManager() {
        return new InputManager(inputMapper(), inputView());
    }

    private InputView inputView() {
        return new InputView(inputValidator());
    }

    private InputValidator inputValidator() {
        return new InputValidator();
    }

    private InputMapper inputMapper() {
        return new InputMapper();
    }

    private OutputView outputView() {
        return new OutputView(outputFormatter());
    }

    private OutputFormatter outputFormatter() {
        return new OutputFormatter();
    }
}

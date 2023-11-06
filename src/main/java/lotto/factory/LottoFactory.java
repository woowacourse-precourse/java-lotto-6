package lotto.factory;

import lotto.controller.LottoController;
import lotto.domain.LottoStatistics;
import lotto.domain.Lottos;
import lotto.io.InputManager;
import lotto.io.InputMapper;
import lotto.io.InputView;
import lotto.io.OutputView;
import lotto.service.LottoService;
import lotto.validator.InputValidator;

public class LottoFactory {

    private static class LottoFactoryHelper {
        private static final LottoFactory INSTANCE = new LottoFactory();
    }

    public static LottoFactory getInstance() {
        return LottoFactoryHelper.INSTANCE;
    }

    public LottoController lottoController() {
        return new LottoController(inputManager(), outputView(), lottoService());
    }

    private InputManager inputManager() {
        return new InputManager(inputView(), inputMapper());
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
        return new OutputView();
    }


    private LottoService lottoService() {
        return new LottoService(lottos(), lottoStatistics());
    }

    private Lottos lottos() {
        return new Lottos();
    }

    private LottoStatistics lottoStatistics() {
        return new LottoStatistics();
    }
}

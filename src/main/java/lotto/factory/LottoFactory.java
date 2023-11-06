package lotto.factory;

import lotto.controller.LottoController;
import lotto.domain.LottoStatistics;
import lotto.domain.PlayerLottoNumbers;
import lotto.io.InputMapper;
import lotto.io.InputView;
import lotto.io.IoManager;
import lotto.io.OutputView;
import lotto.service.LottoService;
import lotto.validator.InputValidator;

public class LottoFactory {

    private LottoFactory() {
    }

    public static LottoFactory getInstance() {
        return LottoFactoryHelper.INSTANCE;
    }

    public LottoController lottoController() {
        return new LottoController(ioManager(), outputView(), lottoService());
    }

    private IoManager ioManager() {
        return new IoManager(inputView(), inputMapper(), outputView());
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
        return OutputView.getInstance();
    }

    private LottoService lottoService() {
        return new LottoService(playerLottoNumbers(), lottoStatistics());
    }

    private PlayerLottoNumbers playerLottoNumbers() {
        return new PlayerLottoNumbers();
    }

    private LottoStatistics lottoStatistics() {
        return new LottoStatistics();
    }

    private static class LottoFactoryHelper {
        private static final LottoFactory INSTANCE = new LottoFactory();
    }
}

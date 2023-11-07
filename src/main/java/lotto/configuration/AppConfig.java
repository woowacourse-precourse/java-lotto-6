package lotto.configuration;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {
    private InputView inputView() {
        return new InputView();
    }

    private OutputView outputView() {
        return new OutputView();
    }

    private LottoService lottoService() {
        return new LottoService();
    }

    public LottoController lottoController() {
        return new LottoController(inputView(), outputView(), lottoService());
    }

}

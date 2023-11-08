package lotto;

import lotto.controller.GameController;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.InputViewProxy;
import lotto.view.OutputView;

public class DependencyConfig {

    public GameController gameController() {
        return new GameController(lottoService(), inputViewProxy(), outputView());
    }

    private InputViewProxy inputViewProxy() {
        return new InputViewProxy(inputView());
    }

    private InputView inputView() {
        return InputView.getInstance();
    }

    private OutputView outputView() {
        return OutputView.getInstance();
    }

    private LottoService lottoService() {
        return LottoService.getInstance();
    }
}

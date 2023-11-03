package lotto;

import lotto.controller.GameController;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class DependencyConfig {

    public GameController gameController() {
        return new GameController(racingService(), inputView(), outputView());
    }

    private InputView inputView() {
        return InputView.getInstance();
    }

    private OutputView outputView() {
        return OutputView.getInstance();
    }

    private LottoService racingService() {
        return LottoService.getInstance();
    }
}

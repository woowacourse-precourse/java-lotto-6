package lotto.global.config;

import lotto.domain.controller.MainController;
import lotto.domain.service.LottoService;
import lotto.domain.view.InputView;
import lotto.domain.view.OutputView;

public class DependencyContainer {
    private final MainController mainController;

    public DependencyContainer() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoService gameService = new LottoService();
        this.mainController = createMainController(inputView, outputView, gameService);
    }

    private MainController createMainController(InputView inputView, OutputView outputView, LottoService lottoService) {
        return new MainController(inputView, outputView, lottoService);
    }

    public MainController getMainController() {
        return mainController;
    }
}

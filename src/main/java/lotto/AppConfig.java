package lotto;


import lotto.controller.Controller;
import lotto.domain.lotto.strategy.CreateStrategy;
import lotto.domain.lotto.strategy.RandomCreateStrategy;
import lotto.service.Service;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class AppConfig {

    private static final AppConfig APP_CONFIG = new AppConfig();

    public final Controller controller;
    public final Service service;
    public final CreateStrategy createStrategy;
    public final InputView inputView;
    public final OutputView outputView;

    private AppConfig() {
        this.outputView = initOutputView();
        this.inputView = initInputView(outputView);
        this.createStrategy = initCreateStrategy();
        this.service = initGameService();
        this.controller = initController(service, inputView, outputView, createStrategy);
    }

    public static AppConfig getInstance() {
        return APP_CONFIG;
    }

    private OutputView initOutputView() {
        return new OutputView();
    }

    private InputView initInputView(final OutputView outputView) {
        return new InputView(outputView);
    }

    private CreateStrategy initCreateStrategy() {
        return new RandomCreateStrategy();
    }

    private Service initGameService() {
        return new Service();
    }

    private Controller initController(final Service service,
                                      final InputView inputView,
                                      final OutputView outputView,
                                      final CreateStrategy createStrategy) {
        return new Controller(service, inputView, outputView, createStrategy);
    }
}

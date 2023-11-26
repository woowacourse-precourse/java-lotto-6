package lotto;


import lotto.controller.Controller;
import lotto.domain.lotto.strategy.CreateStrategy;
import lotto.domain.lotto.strategy.RandomCreateStrategy;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class AppConfig {

    private static final AppConfig APP_CONFIG = new AppConfig();

    public final Controller controller;

    public final CreateStrategy createStrategy;
    public final InputView inputView;
    public final OutputView outputView;

    private AppConfig() {
        this.outputView = initOutputView();
        this.inputView = initInputView(outputView);
        this.createStrategy = initCreateStrategy();
        this.controller = initController(inputView, outputView, createStrategy);
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


    private Controller initController(final InputView inputView,
                                      final OutputView outputView,
                                      final CreateStrategy createStrategy) {
        return new Controller(inputView, outputView, createStrategy);
    }
}

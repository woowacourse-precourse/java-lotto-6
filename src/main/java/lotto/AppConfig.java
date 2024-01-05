package lotto;

import lotto.controller.GameController;
import lotto.utils.generator.RandomNumber;
import lotto.utils.generator.RandomNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.reader.DefaultReader;
import lotto.view.reader.Reader;

public class AppConfig {

    private static final AppConfig APP_CONFIG = new AppConfig();

    public final DefaultReader reader;
    public final InputView inputView;
    public final OutputView outputView;
    public final RandomNumber randomNumber;
    public final GameController gameController;

    private AppConfig() {
        this.reader = initReader();
        this.inputView = initInputView(reader);
        this.outputView = initOutputView();
        this.randomNumber = initRandomNumber();
        this.gameController = initGameController(inputView, outputView);
    }

    public static AppConfig getInstance() {
        return APP_CONFIG;
    }

    private DefaultReader initReader() {
        return new DefaultReader();
    }

    private InputView initInputView(final Reader reader) {
        return new InputView(reader);
    }

    private OutputView initOutputView() {
        return new OutputView();
    }

    private RandomNumber initRandomNumber() {
        return new RandomNumberGenerator();
    }

    private GameController initGameController(final InputView inputView, final OutputView outputView) {
        return new GameController(inputView, outputView);
    }
}

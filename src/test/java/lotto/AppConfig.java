package lotto;

import lotto.controller.GameController;
import lotto.utils.generator.CustomRandomNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.reader.CustomReader;
import lotto.view.reader.Reader;

public class AppConfig {

    private static final AppConfig APP_CONFIG = new AppConfig();

    public final CustomReader reader;
    public final InputView inputView;
    public final OutputView outputView;
    public final CustomRandomNumberGenerator customRandomNumber;
    public final GameController gameController;

    private AppConfig() {
        this.reader = initReader();
        this.inputView = initInputView(reader);
        this.outputView = initOutputView();
        this.customRandomNumber = initCustomRandomNumber();
        this.gameController = initGameController(inputView, outputView);
    }

    public static AppConfig getInstance() {
        return APP_CONFIG;
    }

    private CustomReader initReader() {
        return new CustomReader();
    }

    private InputView initInputView(final Reader reader) {
        return new InputView(reader);
    }

    private OutputView initOutputView() {
        return new OutputView();
    }

    private CustomRandomNumberGenerator initCustomRandomNumber() {
        return new CustomRandomNumberGenerator();
    }

    private GameController initGameController(final InputView inputView, final OutputView outputView) {
        return new GameController(inputView, outputView);
    }
}

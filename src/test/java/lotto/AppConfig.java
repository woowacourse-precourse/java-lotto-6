package lotto;

import lotto.view.InputView;
import lotto.view.reader.CustomReader;
import lotto.view.reader.Reader;

public class AppConfig {

    private static final AppConfig APP_CONFIG = new AppConfig();

    public final CustomReader reader;
    public final InputView inputView;

    private AppConfig() {
        this.reader = initReader();
        this.inputView = initInputView(reader);
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
}

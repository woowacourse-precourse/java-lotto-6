package lotto.configurer;

import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfigurer {

    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }
}

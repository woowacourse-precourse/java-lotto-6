package lotto.view.facade;

import lotto.view.console.ExceptionView;
import lotto.view.console.InputView;
import lotto.view.console.OutputView;

public class AmountViewFacade {
    public static String ask() {
        OutputView.printInputAmount();
        return InputView.readAmount();
    }

    public static String errorAndAsk(String errorMessage) {
        ExceptionView.printError(errorMessage);
        return ask();
    }
}

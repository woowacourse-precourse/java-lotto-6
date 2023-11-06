package lotto.view.facade;

import lotto.view.console.ExceptionView;
import lotto.view.console.InputView;
import lotto.view.console.OutputView;

public class WinningNumbersViewFacade {
    public static String ask() {
        OutputView.printInputWinningNumbers();
        return InputView.readInput();
    }

    public static String errorAndAsk(String errorMessage) {
        ExceptionView.printError(errorMessage);
        return ask();
    }

}

package lotto.view.facade;

import lotto.view.console.ExceptionView;
import lotto.view.console.InputView;
import lotto.view.console.OutputView;

public class AmountViewFacade implements ViewFacade {
    @Override
    public String ask() {
        OutputView.printInputAmount();
        return InputView.readInput();
    }

    @Override
    public String errorAndAsk(String errorMessage) {
        ExceptionView.printError(errorMessage);
        return ask();
    }
}

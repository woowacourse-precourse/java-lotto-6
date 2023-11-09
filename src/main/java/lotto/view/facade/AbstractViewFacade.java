package lotto.view.facade;

import lotto.view.console.ExceptionView;
import lotto.view.console.InputView;

public abstract class AbstractViewFacade implements ViewFacade {

    @Override
    public String ask() {
        printMessage();
        return InputView.readInput();
    }

    @Override
    public String errorAndAsk(String errorMessage) {
        ExceptionView.printError(errorMessage);
        return ask();
    }

    protected abstract void printMessage();
}

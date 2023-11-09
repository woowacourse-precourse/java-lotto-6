package lotto.view.facade;

import lotto.view.console.OutputView;

public class WinningNumbersViewFacade extends AbstractViewFacade {

    @Override
    protected void printMessage() {
        OutputView.printInputWinningNumbers();
    }
}

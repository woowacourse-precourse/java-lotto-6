package lotto.view.facade;

import lotto.view.console.OutputView;

public class AmountViewFacade extends AbstractViewFacade {

    @Override
    protected void printMessage() {
        OutputView.printInputAmount();
    }
}

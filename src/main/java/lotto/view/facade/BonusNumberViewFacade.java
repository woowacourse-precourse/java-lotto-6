package lotto.view.facade;

import lotto.view.console.OutputView;

public class BonusNumberViewFacade extends AbstractViewFacade {
    @Override
    protected void printMessage() {
        OutputView.printInputBonus();
    }
}

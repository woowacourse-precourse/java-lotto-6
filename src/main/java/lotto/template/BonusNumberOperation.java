package lotto.template;

import lotto.domain.BonusNumber;
import lotto.domain.WinningNumber;
import lotto.view.InputView;

public class BonusNumberOperation implements Operation<BonusNumber> {
    private final WinningNumber winningNumber;

    public BonusNumberOperation(WinningNumber winningNumber) {
        this.winningNumber = winningNumber;
    }

    @Override
    public BonusNumber execute() throws IllegalArgumentException {
        return new BonusNumber(winningNumber.getWinningNumber(), InputView.BonusNumber());
    }
}

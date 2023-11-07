package lotto.validation;

import lotto.domain.BonusNumber;
import lotto.domain.WinningLotto;
import lotto.system.ErrorMessage;
import lotto.view.OutputView;

public class RuntimeValidation {
    public void runtimeCompareBounsWithWinning(BonusNumber bonusNumber, WinningLotto winningLotto) {
        while (true) {
            try {
                if (winningLotto.contains(bonusNumber.getBonusNumber())) {
                    throw new IllegalArgumentException(ErrorMessage.ALREADY_EXIST);
                }
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printMessage(e.getMessage());

                bonusNumber = new BonusNumber();
            }
        }
    }
}

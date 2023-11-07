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
                // 여기서는 예외를 던지지 않으면 정상적으로 보너스 번호를 설정한 것이므로
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printMessage(e.getMessage());

                bonusNumber = new BonusNumber();
            }
        }
    }
}

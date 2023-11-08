package lotto.validator;

import lotto.domain.BonusNumber;
import lotto.domain.WinningLotto;
import lotto.system.SystemMessages;

public class InputValidator {
    public void checkBonusNumber(BonusNumber bonusNumber, WinningLotto winningLotto) {
        if (winningLotto.contains(bonusNumber.getBonusNumber())) {
            throw new IllegalArgumentException(SystemMessages.BONUS_NUMBER_EXISTS_IN_WINNING_LOTTO);
        }
    }
}

package lotto.verifier;

import lotto.domain.BonusNumber;
import lotto.domain.WinningLotto;
import lotto.system.ExceptionMessage;

public class RuntimeVerifier {

    public void checkBonusNumberExistsInWinningLotto(WinningLotto winningLotto, BonusNumber bonusNumber) {
        if (winningLotto.contains(bonusNumber.getBonusNumber()))
            throw new IllegalStateException(ExceptionMessage.BONUS_NUMBER_EXISTS_IN_WINNING_LOTTO);
    }
}

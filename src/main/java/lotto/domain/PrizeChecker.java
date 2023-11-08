package lotto.domain;

import static lotto.utils.ErrorMessages.WINNING_NUMBERS_CONTAINS_BONUS_NUMBER;

import lotto.domain.Lotto;
import lotto.domain.wrapper.PurchaseAmount;
import lotto.utils.LottoConstantValue;
import lotto.utils.Prize;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        validateWinningLottoNotContainsBonusNumber(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateWinningLottoNotContainsBonusNumber(Lotto winningLotto, int bonusNumber) {
        if (winningLotto.hasNumber(bonusNumber)) {
            throw new IllegalArgumentException(WINNING_NUMBERS_CONTAINS_BONUS_NUMBER);
        }
    }

    public Prize getPrize(Lotto lotto) {
        int sameCount = lotto.getSameCount(winningLotto);
        if (Prize.canGetPrize(sameCount)) {
            boolean hasBonusNumber = lotto.hasNumber(bonusNumber);
            return Prize.getPrize(sameCount, hasBonusNumber);
        }
        return Prize.NO_PRIZE;
    }
}

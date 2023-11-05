package lotto.model;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoPrize;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        validateDuplication(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public void validateDuplication(Lotto winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.HAS_DUPLICATED_NUMBER.getMessage());
        }
    }

    public LottoPrize match(Lotto lotto) {
        return LottoPrize.valueOf(
                lotto.matchedCount(this.lotto),
                lotto.contains(this.bonusNumber)
        );
    }
}
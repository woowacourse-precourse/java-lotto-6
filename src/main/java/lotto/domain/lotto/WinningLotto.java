package lotto.domain.lotto;

import lotto.domain.message.ErrorMessage;
import lotto.domain.result.WinningRank;

public class WinningLotto {

    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto lotto, BonusNumber bonusNumber) {
        validate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto lotto, BonusNumber bonusNumber) {
        if (lotto.hasSameNumber(bonusNumber)) {
            throw new IllegalArgumentException(
                    ErrorMessage.DUPLICATION_EXCEPTION_MESSAGE.getMessage());
        }
    }

    public WinningRank findWinningRank(Lotto lotto) {
        int matchCount = lotto.calculateMatchCount(this.lotto);
        boolean hasBonusNumber = lotto.hasSameNumber(bonusNumber);
        return WinningRank.findWinningRank(matchCount, hasBonusNumber);
    }
}

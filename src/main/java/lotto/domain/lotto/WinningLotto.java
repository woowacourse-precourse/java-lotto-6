package lotto.domain.lotto;

import lotto.domain.result.WinningRank;

public class WinningLotto {
    private Lotto lotto;
    private BonusNumber bonusNumber;

    public WinningLotto(Lotto lotto, BonusNumber bonusNumber) {
        validate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto lotto, BonusNumber bonusNumber) {
        if(lotto.hasSameNumber(bonusNumber)) {
            throw new IllegalArgumentException("ERROR");
        }
    }

    public WinningRank findWinningRank(Lotto lotto) {
        int matchCount = lotto.calculateMatchCount(this.lotto);
        boolean hasBonusNumber = lotto.hasSameNumber(bonusNumber);
        return WinningRank.findWinningRank(matchCount, hasBonusNumber);
    }
}

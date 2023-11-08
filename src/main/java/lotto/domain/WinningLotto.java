package lotto.domain;

import lotto.constants.Prize;

public class WinningLotto {
    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    private WinningLotto(Lotto lotto, BonusNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(Lotto lotto, BonusNumber bonusNumber) {
        return new WinningLotto(lotto, bonusNumber);
    }

    public Prize rankPrize(final Lotto lotto) {
        int matches = this.lotto.countMatches(lotto);
        boolean hasBonusNumber = lotto.contains(bonusNumber);
        return Prize.of(matches, hasBonusNumber);
    }
}

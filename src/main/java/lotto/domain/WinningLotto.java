package lotto.domain;

import static lotto.domain.WinningResult.valueOf;

public class WinningLotto {
    private final Lotto winningLotto;
    private final Integer bonusLotto;

    public WinningLotto(Lotto winningLotto, Integer bonusLotto) {
        this.winningLotto = winningLotto;
        this.bonusLotto = bonusLotto;
    }

    public WinningResult compare(Lotto lotto) {
        return valueOf(getMatchNumberCnt(lotto), getMatchBonusNumber(lotto));
    }

    private int getMatchNumberCnt(Lotto lotto) {
        return (int) lotto.matchCount(winningLotto);
    }

    private boolean getMatchBonusNumber(Lotto lotto) {
        return lotto.contain(bonusLotto);
    }
}

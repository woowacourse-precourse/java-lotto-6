package lotto.domain;

import lotto.domain.enums.LottoReward;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(final Lotto lotto, final int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public LottoReward findCompareResult(final Lotto compareLotto) {
        int sameNumberCount = lotto.calculateSameCount(compareLotto);
        boolean hasBonusNumber = compareLotto.contains(bonusNumber);
        return LottoReward.findLottoReward(sameNumberCount, hasBonusNumber);
    }
}
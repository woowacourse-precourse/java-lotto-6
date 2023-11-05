package lotto.model;

import lotto.constants.LottoPrize;

public class WinningLotto {

    private final Lotto lotto;
    private final Integer bonusNumber;

    public WinningLotto(Lotto lotto, Integer bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Boolean isDrawnLotto(Lotto userLotto) {
        Integer countMatchNumber = userLotto.countMatchNumber(lotto);
        return countMatchNumber >= 3;
    }

    public LottoPrize findLottoPrizeType(Lotto userLotto) {
        Boolean hasBonusNumber = userLotto.hasNumber(bonusNumber);
        Integer countMatchNumber = userLotto.countMatchNumber(lotto);
        return LottoPrize.valueOf(hasBonusNumber, countMatchNumber);
    }
}

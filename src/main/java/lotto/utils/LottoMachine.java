package lotto.utils;

import lotto.constant.LotteryRank;
import lotto.model.Lotto;

public class LottoMachine {
    private Lotto winningLotto;

    private int bonusNumber;

    public LottoMachine(Lotto lotto, int bonusNumber) {
        this.winningLotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public LotteryRank calculateLotteryRank(Lotto lotto) {
        int countCommonElements = winningLotto.matchingNumbersCount(lotto);
        boolean containsBonusNumber = lotto.containsNumber(bonusNumber);
    }
}

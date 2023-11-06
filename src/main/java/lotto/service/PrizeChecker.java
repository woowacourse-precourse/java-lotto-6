package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.wrapper.BonusNumber;
import lotto.utils.Prize;

public class PrizeChecker {
    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    public PrizeChecker(Lotto winningLotto, BonusNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public Prize calculatePrize(Lotto lotto) {
        int sameCount = lotto.getSameCount(winningLotto);
        if (Prize.canGetPrize(sameCount)) {
            boolean hasBonusNumber = lotto.doesHaveLottoNumber(bonusNumber);
            return Prize.getPrize(sameCount, hasBonusNumber);
        }
        return Prize.NO_PRIZE;
    }
}

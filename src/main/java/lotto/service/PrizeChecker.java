package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.wrapper.BonusNumber;
import lotto.domain.wrapper.LottoNumber;
import lotto.utils.ErrorMessage;
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
        boolean hasBonusNumber = lotto.doesHaveLottoNumber(bonusNumber);
        return Prize.getPrizeRank(sameCount, hasBonusNumber);
    }
}

package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class RankDeterminer {
    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    public RankDeterminer(Lotto winningLotto, BonusNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private LottoRank determineEachRank(Lotto lotto) {
        int matchingCount = lotto.countMatchingNumbers(winningLotto);
        boolean isSameBonus = lotto.isContainBonusNumber(bonusNumber.getBonusNumber());
        LottoRank rank = LottoRank.findRank(matchingCount);
        if (rank.equals(LottoRank.THIRD) && isSameBonus) {
            return LottoRank.SECOND;
        }

        return rank;
    }
}

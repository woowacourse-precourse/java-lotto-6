package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RankDeterminer {
    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    public RankDeterminer(Lotto winningLotto, BonusNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public List<LottoRank> determineAllRank(List<Lotto> userLottos) {
        return userLottos.stream()
                .map(this::determineEachRank)
                .collect(Collectors.toList());
    }

    private LottoRank determineEachRank(Lotto lotto) {
        int matchingCount = lotto.countMatchingNumbers(winningLotto);
        boolean isSameBonus = lotto.isContainNumber(bonusNumber.getBonusNumber());

        LottoRank rank = LottoRank.findRank(matchingCount);
        if (rank.equals(LottoRank.THIRD) && isSameBonus) {
            return LottoRank.SECOND;
        }

        return rank;
    }
}

package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class RankCalculator {
    private final HitNumberCalculator hitNumberCalculator = new HitNumberCalculator();

    public List<Rank> calculateAllRanks(List<Lotto> purchasedLotto, Lotto winningLotto, int bonusNumber) {
        return purchasedLotto.stream()
                .map(lotto -> calculateRank(lotto, winningLotto, bonusNumber))
                .collect(Collectors.toList());
    }

    private Rank calculateRank(Lotto purchasedLotto, Lotto winningLotto, int bonusNumber) {
        int hitCount = hitNumberCalculator.hitNumberCounter(purchasedLotto.getNumbers(), winningLotto.getNumbers());
        boolean isBonusIncluded = hitNumberCalculator.isBonusNumberIncluded(purchasedLotto.getNumbers(), bonusNumber);
        return Rank.getRank(hitCount, isBonusIncluded);
    }
}
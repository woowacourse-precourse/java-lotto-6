package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class RankCalculator {
    private final HitNumberCalculator hitNumberCalculator = new HitNumberCalculator();

    public List<Rank> calculateAllRanks(List<Lotto> purchasedLotto, Lotto winningLotto, int bonusNumber) {
        return purchasedLotto.stream()
                .map(lotto -> calculateOneRank(lotto, winningLotto, bonusNumber))
                .collect(Collectors.toList());
    }

    private Rank calculateOneRank(Lotto purchasedLotto, Lotto winningLotto, int bonusNumber) {
        int hitCount = calculateHitWinningNumber(purchasedLotto, winningLotto);
        boolean isBonusIncluded = calculateHitBonusNumber(purchasedLotto, bonusNumber);
        return Rank.getRank(hitCount, isBonusIncluded);
    }

    private int calculateHitWinningNumber(Lotto purchasedLotto, Lotto winningLotto) {
        List<Integer> purchasedLottoNumbers = purchasedLotto.getNumbers();
        List<Integer> winningLottoNumbers = winningLotto.getNumbers();
        return hitNumberCalculator.hitNumberCounter(purchasedLottoNumbers, winningLottoNumbers);
    }

    private boolean calculateHitBonusNumber(Lotto purchasedLotto, int bonusNumber) {
        List<Integer> purchasedLottoNumbers = purchasedLotto.getNumbers();
        return hitNumberCalculator.isBonusNumberIncluded(purchasedLottoNumbers, bonusNumber);
    }
}
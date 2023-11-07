package lotto.domain;

import java.util.List;
import lotto.constants.WinningCriteria;

public class WinningStatisticsCalculator {

    private final PurchasedLottos purchasedLottos;
    private final WinningLotto winningLotto;

    public WinningStatisticsCalculator(PurchasedLottos purchasedLottos, WinningLotto winningLotto) {
        this.purchasedLottos = purchasedLottos;
        this.winningLotto = winningLotto;
    }

    public WinningStatistics calculateWinningStatistics() {
        WinningStatistics statistics = new WinningStatistics();
        for (Lotto lotto : purchasedLottos.getLottos()) {
            WinningCriteria criteria = calculateWinningCriteria(lotto);
            statistics.addResult(criteria);
        }
        return statistics;
    }

    private WinningCriteria calculateWinningCriteria(Lotto lotto) {
        int matchCount = countMatchingNumbers(lotto);
        boolean hasBonus = hasBonusNumber(lotto);
        WinningCriteria criteria = WinningCriteria.getRating(matchCount, hasBonus);
        return criteria;
    }

    private int countMatchingNumbers(Lotto lotto) {
        List<Integer> winningNumbers = winningLotto.winningNumbers().getNumbers();
        List<Integer> lottoNumbers = lotto.getNumbers();
        int matchingCount = (int) lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
        return matchingCount;
    }

    private boolean hasBonusNumber(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        return lottoNumbers.contains(winningLotto.bonusNumber().getBonusNumber());
    }
}

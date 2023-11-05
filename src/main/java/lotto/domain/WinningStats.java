package lotto.domain;

import java.util.List;
import java.util.stream.IntStream;
import lotto.system.LottoRankConstant;
import lotto.system.SystemConstant;

public class WinningStats {
    private final List<WinningStat> winningCountByRank;

    private final List<WinningStat> temporalWinngCount = IntStream.range(0,
                    SystemConstant.WINNING_STATS_SIZE.getValue())
            .mapToObj(i -> WinningStat.create())
            .toList();

    private WinningStats(PurchasedLottos purchasedLottos, Lotto winningNumbers, BonusNumber bonusNumber) {
        countWinningCountByRank(purchasedLottos, winningNumbers, bonusNumber);
        winningCountByRank = temporalWinngCount;
    }

    public static WinningStats of(PurchasedLottos purchasedLottos, Lotto winningNumbers, BonusNumber bonusNumber) {
        return new WinningStats(purchasedLottos, winningNumbers, bonusNumber);
    }

    private void countWinningCountByRank(PurchasedLottos purchasedLottos,
                                         Lotto winningNumbers, BonusNumber bonusNumber) {
        purchasedLottos.stream()
                .forEach(i -> checkRank(i.countMatchingNumbers(winningNumbers), i.contains(bonusNumber)));

    }

    private void checkRank(int matchingNumbers, boolean hasBonusNumber) {
        for (int i = SystemConstant.WINNING_STATS_START.getValue();
             i < SystemConstant.WINNING_STATS_SIZE.getValue(); i++) {
            if (isRank(LottoRankConstant.findByRank(i), matchingNumbers, hasBonusNumber)) {
                temporalWinngCount.get(i).adder();
            }
        }
    }

    private boolean isRank(LottoRankConstant lottoRankConstant, int matchingNumbers, boolean hasBonusNumber) {
        return lottoRankConstant.getMatchingNumbers() == matchingNumbers
                && lottoRankConstant.getHasBonusNumber() == hasBonusNumber;
    }
}

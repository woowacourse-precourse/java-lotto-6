package lotto.domain;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import lotto.system.SystemConstant;

public class WinningStats {
    private final List<WinningStat> winningCountByRank;

    private final List<WinningStat> temporalWinngCount = IntStream.range(SystemConstant.WINNING_STATS_START.getValue(),
                    SystemConstant.WINNING_STATS_SIZE.getValue())
            .mapToObj(WinningStat::create)
            .toList();
    // TODO 2023-11-06 7:33 하나로 줄이던가 final 떼기

    private WinningStats(PurchasedLottos purchasedLottos, Lotto winningNumbers, Ball bonusNumber) {
        countWinningCountByRank(purchasedLottos, winningNumbers, bonusNumber);
        winningCountByRank = temporalWinngCount;
        // TODO 2023-11-06 04:04 파라미터 개수 줄이기 (winningNumbers와 bonusNumber를 합친 객체를 만들어서 받는다.)
    }

    public static WinningStats of(PurchasedLottos purchasedLottos, Lotto winningNumbers, Ball bonusNumber) {
        return new WinningStats(purchasedLottos, winningNumbers, bonusNumber);
    }

    private void countWinningCountByRank(PurchasedLottos purchasedLottos,
                                         Lotto winningNumbers, Ball bonusNumber) {
        purchasedLottos.stream()
                .forEach(i -> checkRank(i.countMatchingNumbers(winningNumbers), i.contains(bonusNumber)));
    }

    private void checkRank(int matchingNumbers, boolean hasBonusNumber) {
        temporalWinngCount.stream()
                .filter(i -> i.isThis(matchingNumbers, hasBonusNumber))
                .findFirst()
                .ifPresent(WinningStat::adder);
    }

    public Stream<WinningStat> stream() {
        return winningCountByRank.stream();
    }
}

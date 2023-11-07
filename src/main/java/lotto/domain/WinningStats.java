package lotto.domain;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import lotto.system.SystemConstant;

public class WinningStats {
    private final List<WinningStat> winningCountByRank;

    private WinningStats(PurchasedLottos purchasedLottos, WinningNumbersWithBonus winningNumbersWithBonus) {
        winningCountByRank = createEmptyWinningStatList();
        countWinningCountByRank(purchasedLottos, winningNumbersWithBonus);
    }

    public static WinningStats of(PurchasedLottos purchasedLottos, WinningNumbersWithBonus winningNumbersWithBonus) {
        return new WinningStats(purchasedLottos, winningNumbersWithBonus);
    }

    private List<WinningStat> createEmptyWinningStatList() {
        return IntStream.range(SystemConstant.WINNING_STATS_START.getValue(),
                        SystemConstant.WINNING_STATS_SIZE.getValue())
                .mapToObj(WinningStat::create)
                .toList();
    }

    private void countWinningCountByRank(PurchasedLottos purchasedLottos,
                                         WinningNumbersWithBonus winningNumbersWithBonus) {
        purchasedLottos.stream()
                .map(i -> MatchResult.of(i, winningNumbersWithBonus))
                .forEach(this::checkRank);
    }

    private void checkRank(MatchResult matchResult) {
        winningCountByRank.stream()
                .filter(i -> i.isThis(matchResult))
                .findFirst()
                .ifPresent(WinningStat::adder);
    }

    public Stream<WinningStat> stream() {
        return winningCountByRank.stream();
    }

    public long getProfit() {
        return this.stream()
                .map(WinningStat::getProfit)
                .reduce(SystemConstant.NOTHING.getValueToLong(), Long::sum);
    }
}

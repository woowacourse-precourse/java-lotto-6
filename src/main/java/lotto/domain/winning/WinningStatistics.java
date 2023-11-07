package lotto.domain.winning;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import lotto.domain.Lottos;
import lotto.domain.Money;

public final class WinningStatistics {
    private final Map<WinningResult, Integer> statistics;

    private WinningStatistics(Map<WinningResult, Integer> statistics) {
        this.statistics = new EnumMap<>(statistics);
    }

    public static WinningStatistics of(WinningNumbers winningNumbers, Lottos lottos) {
        Map<WinningResult, Integer> statistics = initStatistics();

        lottos.getWinningResults(winningNumbers)
                .forEach(result -> statistics.put(result, statistics.get(result) + 1));

        return new WinningStatistics(statistics);
    }

    private static Map<WinningResult, Integer> initStatistics() {
        Map<WinningResult, Integer> statistics = new EnumMap<>(WinningResult.class);
        Arrays.stream(WinningResult.values())
                .forEach(result -> statistics.put(result, 0));

        return statistics;
    }

    public Money getTotalWinningMoney() {
        return statistics.entrySet().stream()
                .map(this::calculateWinningMoney)
                .reduce(new Money(0), Money::add);
    }

    private Money calculateWinningMoney(Map.Entry<WinningResult, Integer> entry) {
        Money winningMoney = entry.getKey().getWinningMoney();
        int winningCount = entry.getValue();

        return winningMoney.multiply(winningCount);
    }

    public Map<WinningResult, Integer> getStatistics() {
        return new EnumMap<>(statistics);
    }
}

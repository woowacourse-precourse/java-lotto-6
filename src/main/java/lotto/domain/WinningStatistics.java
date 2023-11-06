package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public final class WinningStatistics {
    private final Map<WinningResult, Integer> winningStatistics;

    private WinningStatistics(Map<WinningResult, Integer> winningStatistics) {
        this.winningStatistics = new EnumMap<>(winningStatistics);
    }

    public static WinningStatistics of(WinningNumbers winningNumbers, Lottos lottos) {
        Map<WinningResult, Integer> winningStatistics = initWinningStatistics();

        lottos.getWinningResults(winningNumbers)
                .forEach(winningResult ->
                        winningStatistics.put(winningResult, winningStatistics.get(winningResult) + 1));

        return new WinningStatistics(winningStatistics);
    }

    private static Map<WinningResult, Integer> initWinningStatistics() {
        Map<WinningResult, Integer> winningStatistics = new EnumMap<>(WinningResult.class);
        Arrays.stream(WinningResult.values())
                .forEach(winningResult -> winningStatistics.put(winningResult, 0));

        return winningStatistics;
    }
}

package lotto.domain.winning;

import java.util.EnumMap;
import java.util.Map;
import lotto.domain.number.DrawnNumbers;
import lotto.domain.number.Lottos;

public class WinningStatistics {
    private static final int LOTTO_PRICE = 1_000;
    private final Map<Winning, Integer> winningStatistics;

    private WinningStatistics(Map<Winning, Integer> winningStatistics) {
        this.winningStatistics = winningStatistics;
    }

    public static WinningStatistics of(Lottos lottos, DrawnNumbers drawnNumbers) {
        Map<Winning, Integer> winningStatistics = new EnumMap<>(Winning.class);
        for (Winning winning : Winning.values()) {
            winningStatistics.put(winning, 0);
        }

        lottos.forEach(lotto -> {
            int matchCount = drawnNumbers.countMatches(lotto);
            boolean bonus = drawnNumbers.isBonusNumberIn(lotto);
            Winning winning = Winning.of(matchCount, bonus);
            Integer winningCount = winningStatistics.get(winning);
            winningStatistics.put(winning, ++winningCount);
        });

        return new WinningStatistics(winningStatistics);
    }

    public int count(Winning winning) {
        return winningStatistics.get(winning);
    }

    public double calculateRateOfReturn() {
        double totalWinningAmount = 0;
        int totalWinningCount = 0;
        for (Winning winning : Winning.values()) {
            Integer winningCount = winningStatistics.get(winning);
            totalWinningAmount += winning.getWinningAmount() * winningCount;
            totalWinningCount += winningCount;
        }
        return totalWinningAmount / (totalWinningCount * LOTTO_PRICE) * 100;
    }
}

package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Calculator {
    private static final Integer PERCENTAGE = 100;
    private static final Integer INITIAL_COUNT = 0;
    private static final Integer INCREASE_COUNT = 1;
    private final List<Lotto> playerLottos;
    private final WinningNumbers winningNumbers;
    private final Map<Rank, Integer> winningStatistics;

    public Calculator(List<Lotto> playerLottos, WinningNumbers winningNumbers) {
        this.playerLottos = playerLottos;
        this.winningNumbers = winningNumbers;
        winningStatistics = new EnumMap<>(Rank.class);
    }

    public Map<Rank, Integer> calculateStatistics() {
        initStatistics();
        rankCountForEachLotto();
        return winningStatistics;
    }

    public Double calculateWinningRate(Map<Rank, Integer> winningStatistics, int money) {
        return sumTotalPrize(winningStatistics) / (double) money * PERCENTAGE;
    }

    private Long sumTotalPrize(Map<Rank, Integer> winningResult) {
        return winningResult.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    private void initStatistics() {
        for (Rank rank : Rank.values()) {
            winningStatistics.put(rank, INITIAL_COUNT);
        }
    }

    private void rankCountForEachLotto() {
        for (Lotto lotto : playerLottos) {
            int matchCount = lotto.matchCountWith(winningNumbers.winningLotto());
            boolean isBonusNumberMatched = lotto.contains(winningNumbers.bonusNumber());
            Rank rank = Rank.valueOf(matchCount, isBonusNumberMatched);
            winningStatistics.put(rank, winningStatistics.get(rank) + INCREASE_COUNT);
        }
    }
}

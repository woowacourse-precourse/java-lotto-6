package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Calculator {
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

    public Double calculateWinningRate(Map<Rank, Integer> winningResults, int money) {
        return sumTotalPrize(winningResults) / (double) money * 100;
    }

    private Long sumTotalPrize(Map<Rank, Integer> winningResults) {
        return winningResults.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    private void initStatistics() {
        for (Rank rank : Rank.values()) {
            winningStatistics.put(rank, 0);
        }
    }

    private void rankCountForEachLotto() {
        for (Lotto lotto : playerLottos) {
            int matchCount = lotto.matchCountWith(winningNumbers.winningLotto());
            boolean isBonusNumberMatched = lotto.contains(winningNumbers.bonusNumber());
            Rank rank = Rank.valueOf(matchCount, isBonusNumberMatched);
            winningStatistics.put(rank, winningStatistics.get(rank) + 1);
        }
    }
}

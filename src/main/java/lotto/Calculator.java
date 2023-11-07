package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Calculator {
    private final List<Lotto> userLottos;
    private final WinningNumbers winningNumbers;

    public Calculator(List<Lotto> userLottos, WinningNumbers winningNumbers) {
        this.userLottos = userLottos;
        this.winningNumbers = winningNumbers;
    }

    public Map<Rank, Integer> calculateStatistics() {
        Map<Rank, Integer> winningStatistics = new EnumMap<>(Rank.class);
        Lotto winningLotto = winningNumbers.getLottoNumbers();
        int bonusNumber = winningNumbers.getBonusNumber();
        for (Rank rank : Rank.values()) {
            winningStatistics.put(rank, 0);
        }
        for (Lotto lotto : userLottos) {
            int matchCount = lotto.matchCountWith(winningLotto);
            boolean isBonusNumberMatched = lotto.contains(bonusNumber);
            Rank rank = Rank.valueOf(matchCount, isBonusNumberMatched);
            winningStatistics.put(rank, winningStatistics.get(rank) + 1);
        }
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
}

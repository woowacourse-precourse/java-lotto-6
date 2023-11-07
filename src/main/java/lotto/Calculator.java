package lotto;

import java.util.EnumMap;
import java.util.Map;

public class Calculator {
    private final Lottos userLottos;
    private final WinningNumbers winningNumbers;

    public Calculator(Lottos userLottos, WinningNumbers winningNumbers) {
        this.userLottos = userLottos;
        this.winningNumbers = winningNumbers;
    }

    public WinningStatistics calculateStatistics(int money) {
        Map<Rank, Integer> winningResults = calculateResults();
        Double winningRate = calculateWinningRate(winningResults, money);
        return new WinningStatistics(winningResults, winningRate);
    }

    private Map<Rank, Integer> calculateResults() {
        Map<Rank, Integer> winningResults = new EnumMap<>(Rank.class);
        Lotto winningLotto = winningNumbers.getLottoNumbers();
        int bonusNumber = winningNumbers.getBonusNumber();
        for (Lotto lotto : userLottos.getLottos()) {
            int hitCount = lotto.matchCountWith(winningLotto);
            boolean isBonusNumberMatched = lotto.contains(bonusNumber);
            Rank rank = Rank.valueOf(hitCount, isBonusNumberMatched);
            winningResults.put(rank, winningResults.getOrDefault(rank, 0) + 1);
        }
        return winningResults;
    }

    private Double calculateWinningRate(Map<Rank, Integer> winningResults, int money) {
        return calculateTotalPrize(winningResults) / (double) money * 100;
    }

    private Long calculateTotalPrize(Map<Rank, Integer> winningResults) {
        return winningResults.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
}

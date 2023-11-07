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

    public Map<Rank, Integer> calculateResults() {
        Map<Rank, Integer> winningResults = new EnumMap<>(Rank.class);
        Lotto winningLotto = winningNumbers.getLottoNumbers();
        int bonusNumber = winningNumbers.getBonusNumber();
        for (Rank rank : Rank.values()) {
            winningResults.put(rank, 0);
        }
        for (Lotto lotto : userLottos) {
            int hitCount = lotto.matchCountWith(winningLotto);
            boolean isBonusNumberMatched = lotto.contains(bonusNumber);
            Rank rank = Rank.valueOf(hitCount, isBonusNumberMatched);
            winningResults.put(rank, winningResults.get(rank) + 1);
        }
        return winningResults;
    }

    public Double calculateWinningRate(Map<Rank, Integer> winningResults, int money) {
        return calculateTotalPrize(winningResults) / (double) money * 100;
    }

    private Long calculateTotalPrize(Map<Rank, Integer> winningResults) {
        return winningResults.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
}

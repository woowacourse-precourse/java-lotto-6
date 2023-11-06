package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningResult {
    private final Map<Rank, Integer> result;

    public WinningResult(Map<Rank, Integer> result) {
        this.result = result;
    }

    public int getCount(Rank rank) {
        return result.getOrDefault(rank, 0);
    }

    public int getTotalPrize() {
        return result.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    public static WinningResult calculate(List<Lotto> lottos, WinningNumbers winningNumbers) {
        Map<Rank, Integer> result = new HashMap<>();
        for (Lotto lotto : lottos) {
            Rank rank = winningNumbers.calculateRank(lotto);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
        return new WinningResult(result);
    }
}

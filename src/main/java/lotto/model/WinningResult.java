package lotto.model;


import java.util.HashMap;
import java.util.Map;

public class WinningResult {
    private final Map<LottoRanking, Integer> winningResult = new HashMap<>();

    public Map<LottoRanking, Integer> getWinningResult() {
        return winningResult;
    }

    public void addRanking(LottoRanking ranking) {
        winningResult.put(ranking, winningResult.getOrDefault(ranking, 0) + 1);
    }

    public double getTotalPrize() {
        return winningResult.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
}

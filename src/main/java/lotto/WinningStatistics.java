package lotto;

import java.util.Map;

public record WinningStatistics(Map<Ranking, Integer> rankingNumber) {
    public double getReturnRage(int amount) {
        return rankingNumber.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum() / amount * 100;
    }
}

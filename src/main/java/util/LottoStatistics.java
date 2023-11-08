package util;

import lotto.LottoRank;

import java.util.Map;

public class LottoStatistics {
    private LottoStatistics() {
    }

    static double calculateYield(Map<LottoRank, Integer> rankCounter, int ticketPurchaseAmount) {
        int totalPrizeMoney = rankCounter.entrySet().stream()
                .mapToInt(entry -> Integer.parseInt(
                        entry.getKey()
                                .getPrizeMoney()
                                .replace(",", "")) * entry.getValue())
                .sum();

        return (double) totalPrizeMoney / (ticketPurchaseAmount) * 100;
    }
}

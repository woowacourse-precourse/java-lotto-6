package lotto.model;

import java.util.Map;
import lotto.common.Ranking;

public class WinningPrize {

    public static double getProfit(Map<Ranking, Integer> result, int amount) {
        return calculateProfit(result, amount) * 100;
    }

    private static double calculateProfit(Map<Ranking, Integer> result, int amount) {
        double totalPrize = calculateTotalPrize(result);
        return totalPrize / (double) amount;
    }

    private static double calculateTotalPrize(Map<Ranking, Integer> result) {
        double totalPrize = 0.0;

        for (Ranking rank : Ranking.values()) {
            Integer counts = result.get(rank);
            int prize = Integer.parseInt(rank.getPrize());

            if (counts != null) {
                totalPrize += (double) counts * prize;
            }
        }
        return totalPrize;
    }
}

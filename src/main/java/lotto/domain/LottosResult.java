package lotto.domain;

import java.util.Map;

public class LottosResult {

    public int calculateTotalPrize(Map<Rank, Integer> results) {
        int totalPrize = 0;
        for (Map.Entry<Rank, Integer> entry : results.entrySet()) {
            totalPrize += calculateOncePrize(entry);
        }
        return totalPrize;
    }

    private int calculateOncePrize(Map.Entry<Rank, Integer> entry) {
        Rank rank = entry.getKey();
        int count = entry.getValue();
        int prize = rank.getPrizeMoney();
        return count * prize;
    }
}

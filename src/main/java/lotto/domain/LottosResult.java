package lotto.domain;

import java.util.Map;

public class LottosResult {

    public int calculateTotalPrize(Map<Rank, Integer> results) {
        int totalPrize = 0;
        for (Map.Entry<Rank, Integer> entry : results.entrySet()) {
            Rank rank = entry.getKey();
            int count = entry.getValue();
            int prize = rank.getPrizeMoney();
            totalPrize += count * prize;
        }
        return totalPrize;
    }
}

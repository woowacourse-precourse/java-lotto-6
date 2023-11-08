package lotto.service;

import lotto.utils.LottoRank;

import java.util.LinkedHashMap;
import java.util.Map;

public class TotalPrize {
    private final Map<LottoRank, Integer> prizes;

    public TotalPrize() {
        this.prizes = generateTotalPrize();
    }

    private Map<LottoRank, Integer> generateTotalPrize() {
        Map<LottoRank, Integer> prizes = new LinkedHashMap<>();
        for (LottoRank result : LottoRank.values()) {
            prizes.put(result, 0);
        }
        return prizes;
    }

    public void increasePrize(LottoRank rank) {
        prizes.put(rank, prizes.get(rank) + 1);
    }

    public int getPrizeCount(LottoRank rank) {
        return prizes.get(rank);
    }

    public long sumTotalPrizeAmount() {
        return prizes.keySet()
                .stream()
                .filter(rank -> getPrizeCount(rank) > 0)
                .mapToLong(rank -> getPrizeCount(rank) * rank.prize())
                .sum();
    }
}

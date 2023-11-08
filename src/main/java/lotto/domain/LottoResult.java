package lotto.domain;

import java.util.EnumMap;

public class LottoResult {
    private final EnumMap<Prize, Integer> prizeResults;
    private final double earnRate;

    public LottoResult(EnumMap<Prize, Integer> prizeResults, double earnRate) {
        this.prizeResults = prizeResults;
        this.earnRate = earnRate;
    }

    public EnumMap<Prize, Integer> getPrizeResults() {
        return prizeResults;
    }

    public double getEarnRate() {
        return earnRate;
    }
}

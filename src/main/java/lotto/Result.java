package lotto;

import java.util.EnumMap;

public class Result {
    private final EnumMap<Rank, Integer> rankToCount;
    private final double rateOfReturn;

    public Result(EnumMap<Rank, Integer> rankToCount, double rateOfReturn) {
        this.rankToCount = rankToCount;
        this.rateOfReturn = rateOfReturn;
    }

    public EnumMap<Rank, Integer> getRankToCount() {
        return rankToCount;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }
}

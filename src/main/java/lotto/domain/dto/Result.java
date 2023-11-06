package lotto.domain.dto;

import java.math.BigDecimal;
import java.util.EnumMap;
import lotto.domain.Rank;

public class Result {
    private final EnumMap<Rank, Integer> rankToCount;
    private final BigDecimal rateOfReturn;

    public Result(EnumMap<Rank, Integer> rankToCount, BigDecimal rateOfReturn) {
        this.rankToCount = rankToCount;
        this.rateOfReturn = rateOfReturn;
    }

    public EnumMap<Rank, Integer> getRankToCount() {
        return rankToCount;
    }

    public BigDecimal getRateOfReturn() {
        return rateOfReturn;
    }
}

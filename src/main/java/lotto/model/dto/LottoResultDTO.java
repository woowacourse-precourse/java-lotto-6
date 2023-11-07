package lotto.model.dto;

import lotto.model.PrizeCategory;

import java.util.EnumMap;

public class LottoResultDTO {
    private final EnumMap<PrizeCategory, Integer> matchResults;
    private final double totalReturnRate;

    public LottoResultDTO(EnumMap<PrizeCategory, Integer> matchResults, double totalReturnRate) {
        this.matchResults = matchResults;
        this.totalReturnRate = totalReturnRate;
    }

    public int getMatchResult(PrizeCategory match) {
        return matchResults.getOrDefault(match, 0);
    }

    public double getTotalReturnRate() {
        return this.totalReturnRate;
    }
}

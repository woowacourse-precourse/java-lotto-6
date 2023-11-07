package lotto.model.dto;

import lotto.model.PrizeCategory;

import java.util.EnumMap;

public class LottoResultDTO {
    private final EnumMap<PrizeCategory, Integer> matchResults;

    public LottoResultDTO(EnumMap<PrizeCategory, Integer> matchResults) {
        this.matchResults = matchResults;
    }

    public int getMatchResult(PrizeCategory match) {
        return matchResults.getOrDefault(match, 0);
    }
}

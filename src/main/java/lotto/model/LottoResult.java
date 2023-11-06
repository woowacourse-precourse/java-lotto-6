package lotto.model;

import lotto.constant.RankCategory;

import java.util.EnumMap;

public class LottoResult {
    private final EnumMap<RankCategory, Integer> results;

    public LottoResult(EnumMap<RankCategory, Integer> calculatedResults) {
        results = calculatedResults;
    }

    public EnumMap<RankCategory, Integer> getResults() {
        return results;
    }
}

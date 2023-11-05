package lotto.domain.prize;

import lotto.domain.prize.constants.PrizeRank;

import java.util.EnumMap;
import java.util.List;

public class FinalResults {
    private EnumMap<PrizeRank, Long> finalResults;

    public FinalResults(List<MatchingResults> matchingResults) {
        EnumMap<PrizeRank, Long> results = new EnumMap<>(PrizeRank.class);

        this.finalResults = results;
    }

    public FinalResults from(List<MatchingResults> matchingResults) {
        return new FinalResults(matchingResults);
    }
}

package lotto.domain.prize;

import lotto.domain.prize.constants.PrizeGrade;

import java.util.List;

public class PrizeRank {
    private final List<MatchingResult> matchingResults;

    // Constructor
    private PrizeRank(final List<MatchingResult> matchingResults) {
        this.matchingResults = matchingResults;
    }

    // Static Factory Method
    public static PrizeRank from(final List<MatchingResult> matchingCounts) {
        return new PrizeRank(matchingCounts);
    }

    // Utility Method
    public List<PrizeGrade> findPrizeRanks() {
        return matchingResults.stream()
                .map(PrizeGrade::findPrizeRank)
                .toList();
    }
}

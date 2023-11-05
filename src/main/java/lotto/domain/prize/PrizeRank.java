package lotto.domain.prize;

import lotto.domain.prize.constants.PrizeGrade;

import java.util.List;

public class PrizeRank {
    private final List<MatchingResult> matchingResults;

    private PrizeRank(List<MatchingResult> matchingResults) {
        this.matchingResults = matchingResults;
    }

    public static PrizeRank from(List<MatchingResult> matchingCounts) {
        return new PrizeRank(matchingCounts);
    }

    public List<PrizeGrade> findPrizeRanks() {
        return matchingResults.stream()
                .map(PrizeGrade::findPrizeRank)
                .toList();
    }
}

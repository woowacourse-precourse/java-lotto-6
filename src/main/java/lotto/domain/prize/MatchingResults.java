package lotto.domain.prize;

import lotto.domain.prize.constants.PrizeGrade;

import java.util.List;

public class MatchingResults {
    private final List<MatchingResult> matchingResults;

    // Constructor
    private MatchingResults(final List<MatchingResult> matchingResults) {
        this.matchingResults = matchingResults;
    }

    // Static Factory Method
    public static MatchingResults from(final List<MatchingResult> matchingCounts) {
        return new MatchingResults(matchingCounts);
    }

    // Utility Method
    public List<PrizeGrade> findPrizeGrade() {
        return matchingResults.stream()
                .map(PrizeGrade::findPrizeGrade)
                .toList();
    }
}

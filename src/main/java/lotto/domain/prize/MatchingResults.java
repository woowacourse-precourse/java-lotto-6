package lotto.domain.prize;

import java.util.List;

public class MatchingResults {
    private final List<MatchingResult> matchingResults;

    private MatchingResults(List<MatchingResult> matchingResults) {
        this.matchingResults = matchingResults;
    }

    public static MatchingResults from(List<MatchingResult> matchingCounts) {
        return new MatchingResults(matchingCounts);
    }
}

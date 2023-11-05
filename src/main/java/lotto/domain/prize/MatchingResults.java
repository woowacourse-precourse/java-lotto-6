package lotto.domain.prize;

import java.util.List;

public class MatchingResults {
    private final List<MatchingResult> matchingCounts;

    private MatchingResults(List<MatchingResult> matchingCounts) {
        this.matchingCounts = matchingCounts;
    }

    public static MatchingResults from(List<MatchingResult> matchingCounts) {
        return new MatchingResults(matchingCounts);
    }
}

package lotto.domain;

import java.util.List;
import lotto.domain.constants.WinningGrade;

public class MatchingResults {

    private final List<MatchingResult> results;

    private MatchingResults(List<MatchingResult> results) {
        this.results = results;
    }

    public static MatchingResults from(List<MatchingResult> results) {
        return new MatchingResults(results);
    }

    public List<WinningGrade> receiveLottoRanks() {
        return results.stream()
                .map(WinningGrade::receiveLottoRank)
                .toList();
    }
}

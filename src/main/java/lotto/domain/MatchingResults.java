package lotto.domain;

import java.util.List;
import lotto.enums.WinningGrade;

public class MatchingResults {

    private final List<MatchingResult> results;

    private MatchingResults(final List<MatchingResult> results) {
        this.results = results;
    }

    public static MatchingResults from(final List<MatchingResult> results) {
        return new MatchingResults(results);
    }

    public List<WinningGrade> receiveWinningGrades() {
        return results.stream()
                .map(WinningGrade::receiveLottoRank)
                .toList();
    }
}

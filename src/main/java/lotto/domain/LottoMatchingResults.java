package lotto.domain;

import java.util.List;
import lotto.domain.constants.WinningGrade;

public class LottoMatchingResults {

    private final List<LottoMatchingResult> results;

    private LottoMatchingResults(List<LottoMatchingResult> results) {
        this.results = results;
    }

    public static LottoMatchingResults from(List<LottoMatchingResult> results) {
        return new LottoMatchingResults(results);
    }

    public List<WinningGrade> receiveLottoRanks() {
        return results.stream()
                .map(WinningGrade::receiveLottoRank)
                .toList();
    }
}

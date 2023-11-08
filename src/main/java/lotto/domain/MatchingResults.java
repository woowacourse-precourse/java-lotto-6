package lotto.domain;

import lotto.constants.LottoRank;

import java.util.List;

public class MatchingResults {

    private final List<MatchingResult> matchingResults;

    public MatchingResults(List<MatchingResult> matchingResults) {
        this.matchingResults = matchingResults;
    }

    public List<LottoRank> getLottoRanks() {
        return matchingResults.stream()
                .map(LottoRank::from)
                .toList();
    }
}

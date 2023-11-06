package lotto.domain;

import java.util.List;
import lotto.util.enums.LottoRank;

public class LottoResult {
    private final List<LottoRank> rankResults;

    public LottoResult(List<LottoRank> rankResults) {
        this.rankResults = rankResults;
    }

    public List<LottoRank> getRankResults() {
        return rankResults;
    }
}

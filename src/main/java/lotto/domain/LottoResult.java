package lotto.domain;

import java.util.Map;

public class LottoResult {

    private final Map<WinningStatistics, Integer> ranks;

    public LottoResult(Map<WinningStatistics, Integer> ranks) {
        this.ranks = ranks;
    }
}

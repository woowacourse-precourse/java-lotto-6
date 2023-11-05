package domain;

import java.util.Map;

public class LottoGameResult {
    private final Map<Integer, Long> matchCounts;

    public LottoGameResult(Map<Integer, Long> matchCounts) {
        this.matchCounts = matchCounts;
    }
}

package lotto.dto;

import java.util.Collections;
import java.util.Map;
import lotto.common.LottoRank;

public class LottoGameResultResponse {
    private Map<LottoRank, Integer> gameResults;

    public LottoGameResultResponse(Map<LottoRank, Integer> gameResults) {
        this.gameResults = gameResults;
    }

    public static LottoGameResultResponse from(Map<LottoRank, Integer> gameResultCounts) {
        return new LottoGameResultResponse(gameResultCounts);
    }

    public Map<LottoRank, Integer> getGameResults() {
        return Collections.unmodifiableMap(gameResults);
    }
}

package lotto.dto;

import java.util.Collections;
import java.util.Map;
import lotto.common.LottoRank;

public class LottoGameResultResponse {
    private Map<LottoRank, Integer> gameResultCounts;
    private Double profitRate;

    public LottoGameResultResponse(Map<LottoRank, Integer> gameResultCounts, Double profitRate) {
        this.gameResultCounts = gameResultCounts;
        this.profitRate = profitRate;
    }

    public static LottoGameResultResponse from(Map<LottoRank, Integer> gameResultCounts, Double profitRate) {
        return new LottoGameResultResponse(gameResultCounts, profitRate);
    }

    public Map<LottoRank, Integer> getGameResultCounts() {
        return Collections.unmodifiableMap(gameResultCounts);
    }

    public Double getProfitRate() {
        return profitRate;
    }
}

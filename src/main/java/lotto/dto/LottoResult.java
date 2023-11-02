package lotto.dto;

import static lotto.constant.LottoRanking.NONE;

import java.util.Map;
import lotto.constant.LottoRanking;

public final class LottoResult {

    private final Map<LottoRanking, Integer> winningCounts;
    private final Double profitRate;

    public LottoResult(Map<LottoRanking, Integer> winningCounts, Double profitRate) {
        winningCounts.remove(NONE);
        this.winningCounts = winningCounts;
        this.profitRate = profitRate;
    }

    public Map<LottoRanking, Integer> getWinningCounts() {
        return winningCounts;
    }

    public Double getProfitRate() {
        return profitRate;
    }
}

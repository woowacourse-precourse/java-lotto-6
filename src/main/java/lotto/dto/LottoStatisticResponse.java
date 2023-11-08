package lotto.dto;

import java.util.Collections;
import java.util.Map;
import lotto.domain.lotto.LottoPrize;

public class LottoStatisticResponse {

    private final Map<LottoPrize, Integer> winningCounts;
    private final double earningRate;

    private LottoStatisticResponse(Map<LottoPrize, Integer> prizeCounts, double earningRate) {
        this.winningCounts = prizeCounts;
        this.earningRate = earningRate;
    }

    public static LottoStatisticResponse of(Map<LottoPrize, Integer> prizeCounts,
        double earningRate) {
        return new LottoStatisticResponse(prizeCounts, earningRate);
    }

    public Map<LottoPrize, Integer> getWinningCount() {
        return Collections.unmodifiableMap(winningCounts);
    }

    public double getEarningRate() {
        return earningRate;
    }
}
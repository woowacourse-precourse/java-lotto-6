package lotto.domain;

import static lotto.constant.LottoNumber.PERCENT;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningResult {
    private final Map<LottoRank, Integer> winningResult = new EnumMap<>(LottoRank.class);
    private double profitRate;

    public WinningResult(List<LottoRank> ranks, int money) {
        putMatchCount(ranks);
        //calculateProfitRate(money);
    }

    private void putMatchCount(List<LottoRank> ranks) {
        for (LottoRank rank : ranks) {
            winningResult.put(rank, winningResult.getOrDefault(rank, 0) + 1);
        }
    }

    public Map<LottoRank, Integer> getWinningResult() {
        return winningResult;
    }

    public double getProfitRate() {
        return profitRate;
    }
}

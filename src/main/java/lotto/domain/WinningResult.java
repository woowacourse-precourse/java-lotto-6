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
        calculateProfitRate(money);
    }

    private void putMatchCount(List<LottoRank> ranks) {
        ranks.forEach(rank -> winningResult.put(rank, winningResult.getOrDefault(rank, 0) + 1));
    }

    private void calculateProfitRate(int money) {
        double profit = winningResult.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().multiple(entry.getValue()))
                .sum();

        this.profitRate = (profit / money) * PERCENT.getNumber();
    }

    public Map<LottoRank, Integer> getWinningResult() {
        return winningResult;
    }

    public double getProfitRate() {
        return profitRate;
    }
}

package lotto.domain;

import static lotto.constant.LottoNumber.COUNT_UNIT;
import static lotto.constant.LottoNumber.PERCENT;
import static lotto.constant.LottoNumber.ZERO;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningResult {
    private final Map<LottoRank, Integer> winningResult = new EnumMap<>(LottoRank.class);
    private double profitRate;

    public WinningResult(List<LottoRank> ranks, int money) {
        initializeWinningResult();
        putMatchCount(ranks);
        calculateProfitRate(money);
    }

    private void putMatchCount(List<LottoRank> ranks) {
        ranks.forEach(rank -> winningResult.put(rank,
                winningResult.getOrDefault(rank, ZERO.getNumber()) + COUNT_UNIT.getNumber()));
    }

    private void calculateProfitRate(int money) {
        double profit = winningResult.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().multiple(entry.getValue()))
                .sum();

        this.profitRate = (profit / money) * PERCENT.getNumber();
    }

    private void initializeWinningResult() {
        winningResult.put(LottoRank.FIRST, 0);
        winningResult.put(LottoRank.SECOND, 0);
        winningResult.put(LottoRank.THIRD, 0);
        winningResult.put(LottoRank.FOURTH, 0);
        winningResult.put(LottoRank.FIFTH, 0);
        winningResult.put(LottoRank.DEFAULT, 0);
    }

    public Map<LottoRank, Integer> getWinningResult() {
        return winningResult;
    }

    public double getProfitRate() {
        return profitRate;
    }
}

package lotto.domain.statistic;

import static lotto.domain.constant.LottoConstant.LOTTO_PRICE;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;
import lotto.domain.ranking.LottoRanking;

public class Statistic {

    private static final int ONE = 1;
    private static final int EARNING_RATE_CONSTANT = 100;

    private final Map<LottoRanking, Integer> winningResult;

    private Statistic(Map<LottoRanking, Integer> winningCount) {
        this.winningResult = winningCount;
    }

    public static Statistic init() {
        Map<LottoRanking, Integer> winningCount = new EnumMap<>(LottoRanking.class);

        LottoRanking[] rankings = LottoRanking.values();
        for (LottoRanking ranking : rankings) {
            winningCount.put(ranking, 0);
        }

        return new Statistic(winningCount);
    }

    public Map<LottoRanking, Integer> getWinningResult() {
        return Collections.unmodifiableMap(winningResult);
    }

    public Set<LottoRanking> keySet() {
        return winningResult.keySet();
    }

    public int get(LottoRanking lottoRanking) {
        return winningResult.get(lottoRanking);
    }

    public void addCount(LottoRanking lottoRanking) {
        winningResult.compute(lottoRanking, (key, value) -> value + ONE);
    }

    public double calculateEarningRate() {
        double principal = calculatePrincipal();
        double totalPrize = calculateTotalPrize();

        return (totalPrize / principal) * EARNING_RATE_CONSTANT;
    }

    private double calculatePrincipal() {
        return winningResult.keySet().stream()
            .mapToDouble(key -> winningResult.get(key) * LOTTO_PRICE.getValue())
            .sum();
    }

    private double calculateTotalPrize() {
        return winningResult.keySet().stream()
            .mapToDouble(key -> winningResult.get(key) * key.getPrizeValue())
            .sum();
    }
}

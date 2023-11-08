package lotto.model;

import java.util.List;
import java.util.Map;

public class StatisticsResult {
    private final int purchaseAmount;
    private final int lottoPrice;
    private List<Result> results;

    public StatisticsResult(int purchaseAmount, int lottoPrice) {
        this.purchaseAmount = purchaseAmount;
        this.lottoPrice = lottoPrice;
    }

    public void addLottoResults(final List<Result> results) {
        this.results = results;
    }

    public double getFinalReturnRate() {
        double winningAmount = caculateTotalWinningAmount();
        double rawReturnRate = (winningAmount / (double) purchaseAmount) * 100;
        return Math.round(rawReturnRate * 100.0) / 100.0;
    }


    public Map<Result, Integer> getFinalResult() {
        Map<Result, Integer> resultsMap = Result.getBaseMap();
        results.forEach(results -> resultsMap.merge(results, 1, (oldValue, newValue) -> oldValue += newValue));
        return resultsMap;
    }

    public int caculateLottoCount() {
        return purchaseAmount / lottoPrice;
    }

    private int caculateTotalWinningAmount() {
        return results.stream()
                .mapToInt(Result::getPrize)
                .sum();
    }
}

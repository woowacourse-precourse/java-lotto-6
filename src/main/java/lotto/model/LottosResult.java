package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LottosResult {
    private final List<LottoResult> lottoResults;
    private EnumMap<LottoResult, Integer> resultCounts;
    private double totalProfit = 0.0;

    public LottosResult(final List<LottoResult> givenLottosResults){
        this.lottoResults = givenLottosResults;
        this.resultCounts = new EnumMap<>(LottoResult.class);
        for (LottoResult result : givenLottosResults) {
            if(!result.equals(LottoResult.UNDER_THREE)) this.resultCounts.put(result, this.resultCounts.getOrDefault(result,0) + 1);
        }
    }
    public void countProfitable(int money) {
        int totalPrize = 0;
        for (Map.Entry<LottoResult, Integer> entry : resultCounts.entrySet()) {
            totalPrize += entry.getKey().getPrizeAmount() * entry.getValue();
        }
        this.totalProfit = (totalPrize) / (double) money * 100;
    }

    public String getBallCountMessage() {
        StringBuilder sb = new StringBuilder();
        for (LottoResult result : LottoResult.values()) {
            if(!result.equals(LottoResult.UNDER_THREE))
                sb.append(result.getMessage()).append(" - ").append(this.getResultCounts().getOrDefault(result,0)).append("개\n");
        }
        return sb.toString();
    }
    public EnumMap<LottoResult, Integer> getResultCounts() {
        return resultCounts;
    }

    public double getTotalProfit() {
        return totalProfit;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottosResult that = (LottosResult) o;
        return Objects.equals(lottoResults, that.lottoResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoResults);
    }
}

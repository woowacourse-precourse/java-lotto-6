package lotto.domain;

import java.util.Map;

public class Result {
    private static final Integer PERCENTAGE = 100;
    private Map<LottoRanking, Integer> rankingCount;
    private Double profitRate;
    public Result(Map<LottoRanking, Integer> rankingCount, Money money){
        this.rankingCount = rankingCount;
        this.profitRate = calculateProfitMargin(money);
    }

    public Map<LottoRanking, Integer> getRankingCount() {
        return rankingCount;
    }

    public Double getProfitRate() {
        return profitRate;
    }

    private Double calculateProfitMargin(Money money){
        int amount = money.getAmount();
        int sumProfit = 0;
        for(Map.Entry<LottoRanking, Integer> entry: rankingCount.entrySet()){
            LottoRanking ranking = entry.getKey();
            Integer count = entry.getValue();
            sumProfit += ranking.getWinningMoney() * count;
        }
        return ((double)sumProfit/amount)*PERCENTAGE;
    }
}

package lotto.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AnalysisResult {
    private Map<LottoResult, Integer> rankingcounter;
    private int profit;
    private final int cost;

    private AnalysisResult(Map<LottoResult, Integer> Rankingcounter, int cost, int profit) {
        this.rankingcounter = new LinkedHashMap<>();
        this.cost = cost;
        this.profit = profit;
        for (LottoResult lottoResult: Rankingcounter.keySet()) {
            this.rankingcounter.put(lottoResult, Rankingcounter.get(lottoResult));
        }
    }
    public static AnalysisResult caculate(List<LottoResult> lottoResults){
        Map<LottoResult, Integer> Rankingcounter = new LinkedHashMap<>();
        for (LottoResult lottoResult : LottoResult.values()) {
            if(lottoResult != LottoResult.NONE) Rankingcounter.put(lottoResult, 0);
        }
        int cost = lottoResults.size() * 1000;
        int profit = 0;
        for (LottoResult lottoResult : lottoResults) {
            profit += lottoResult.getWinningMoney();
            if (Rankingcounter.containsKey(lottoResult)) {
                Rankingcounter.put(lottoResult, Rankingcounter.get(lottoResult) + 1);
            }
        }
        return new AnalysisResult(Rankingcounter, cost, profit);
    }

    public int getProfit() {
        return profit;
    }

    public int getCost() {
        return cost;
    }

    public Map<LottoResult, Integer> getRankingcounter() {
        return rankingcounter;
    }
}

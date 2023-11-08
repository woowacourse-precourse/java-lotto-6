package lotto.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class DrawResult {
    private static final int PERCENT_CONSTANT = 100;
    private final Map<LottoRank, Integer> rankMap;

    public DrawResult(Map<LottoRank, Integer> rankMap) {
        rankMap.remove(LottoRank.LOSE);
        this.rankMap = rankMap;
    }

    public Map<LottoRank, Integer> getRankMap() {
        return rankMap;
    }

    public double getEarningRate(int price) {
        int sum = calculateEarningAmount();
        return (double) sum * PERCENT_CONSTANT / price;
    }

    private int calculateEarningAmount() {
        int sum = 0;
        for (Map.Entry<LottoRank, Integer> entry : rankMap.entrySet()) {
            sum += entry.getKey().getWinningAmount() * entry.getValue();
        }
        return sum;
    }

    public Map<String, Integer> getResult() {
        Map<String, Integer> resultMap = new LinkedHashMap<>();
        for (Map.Entry<LottoRank, Integer> entry : rankMap.entrySet()) {
            resultMap.put(entry.getKey().getComent(), entry.getValue());
        }
        return resultMap;
    }
}

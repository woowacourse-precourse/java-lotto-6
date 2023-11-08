package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatistic {
    private final Map<LottoResult, Integer> staticsMap;
    private final double totalEarnRate;

    public LottoStatistic(List<LottoResult> results) {
        staticsMap = new HashMap<>();
        for (LottoResult value : LottoResult.values()) {
            staticsMap.put(value, 0);
        }

        this.totalEarnRate = (double) produceStatistic(results) / (results.size() * 1000) * 100;
    }

    private long produceStatistic(List<LottoResult> results) {
        long prizeSum = 0;
        for (LottoResult result : results) {
            staticsMap.put(result, staticsMap.get(result) + 1);
            prizeSum += result.getPrize();
        }
        return prizeSum;
    }

    public Map<LottoResult, Integer> getStaticsMap() {
        return staticsMap;
    }

    public double getTotalEarnRate() {
        return (double) Math.round(totalEarnRate * 10) / 10;
    }
}

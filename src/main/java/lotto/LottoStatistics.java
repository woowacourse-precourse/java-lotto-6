package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {
    private Map<LottoResult, Integer> statistics;
    private Float returnRate;

    public LottoStatistics() {
        statistics = new HashMap<>(Map.of(
                LottoResult.OTHER, 0,
                LottoResult.MATCH3, 0,
                LottoResult.MATCH4, 0,
                LottoResult.MATCH5, 0,
                LottoResult.MATCH5_AND_BONUS, 0,
                LottoResult.MATCH6, 0
        ));
    }

    public void calcStatistics(List<Lotto> lottoList, List<Integer> winningNumberList, Integer bonusNumber) {
        for (Lotto lotto : lottoList) {
            LottoResult result = lotto.getLottoResult(winningNumberList, bonusNumber);
            statistics.put(result, statistics.get(result) + 1);
        }
        returnRate = calcReturnRate(lottoList.size() * 1000);
    }

    public Map<LottoResult, Integer> getStatistics() {
        return statistics;
    }

    public Float getReturnRate() {
        return returnRate;
    }

    private Float calcReturnRate(Integer totalCost) {
        Long sum = 0L;
        for (LottoResult key : statistics.keySet()) {
            sum += Long.valueOf(statistics.get(key)) * key.getPrize();
        }
        return Math.round(sum.floatValue() / totalCost * 1000) / 10.0f;
    }
}

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

    @Override
    public String toString() {
        StringBuilder msgBuilder = new StringBuilder("");
        for (LottoResult result : statistics.keySet()) {
            if (result == LottoResult.OTHER) {
                continue;
            }
            msgBuilder.append(result.getMsg());
            msgBuilder.append(statistics.get(result));
            msgBuilder.append("개\n");
        }
        msgBuilder.append("총 수익률은 ")
                .append(returnRate)
                .append("%입니다.\n");
        return msgBuilder.toString();
    }

    private Float calcReturnRate(Integer totalCost) {
        Integer sum = 0;
        for (LottoResult key : statistics.keySet()) {
            sum += statistics.get(key) * key.getPrize();
        }
        return Math.round(sum.floatValue() / totalCost * 1000) / 10.0f;
    }
}

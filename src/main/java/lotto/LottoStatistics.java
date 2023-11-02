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
        msgBuilder.append("3개 일치 (5,000원) - ")
                .append(statistics.get(LottoResult.MATCH3)).append("개\n");
        msgBuilder.append("4개 일치 (50,000원) - ")
                .append(statistics.get(LottoResult.MATCH4)).append("개\n");
        msgBuilder.append("5개 일치 (1,500,000원) - ")
                .append(statistics.get(LottoResult.MATCH5)).append("개\n");
        msgBuilder.append("5개 일치, 보너스 볼 일치 (30,000,000원) - ")
                .append(statistics.get(LottoResult.MATCH5_AND_BONUS)).append("개\n");
        msgBuilder.append("6개 일치 (2,000,000,000원) - ")
                .append(statistics.get(LottoResult.MATCH6)).append("개\n");
        msgBuilder.append("총 수익률은 ").append(returnRate).append("%입니다.\n");
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

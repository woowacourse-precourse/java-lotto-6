package lotto.domain;

import java.util.Map;

public class EarningsRate {
    public float getEarningsRate(int purchaseMoney, Map<LottoResult, Integer> resultCounts) {
        //수익률 = (총 당첨금액(개수 * 가격) / 총구입금액) * 100
        int totalPrizeAmount = 0;

        //총 당첨금액 계산
        for (LottoResult result : LottoResult.values()) {
            Integer count = resultCounts.get(result);
            totalPrizeAmount += count * result.getPrize();
        }

        return ((float) totalPrizeAmount / purchaseMoney) * 100;
    }
}

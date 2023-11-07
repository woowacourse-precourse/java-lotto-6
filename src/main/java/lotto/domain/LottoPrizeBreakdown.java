package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.Map;

public class LottoPrizeBreakdown {

    private Map<LottoRank, Integer> prizeDetails;

    public LottoPrizeBreakdown(Map<LottoRank, Integer> prizeDetails) {
        this.prizeDetails = prizeDetails;
    }

    public Map<LottoRank, Integer> getReport() {
        return Collections.unmodifiableMap(prizeDetails);
    }

    /**
     * 구입 금액과 당첨 금액으로 수익률을 계산한다
     * 예시) 구입 금액 = 8,000, 당첨 금액 = 5,000 수익률 = 62.5% (소수점 둘째 자리에서 반올림)
     *
     * @param money
     * @return (당첨 금액 / 구입 금액) * 100
     */
    public RateOfReturn getRateOfReturn(Money money) {
        BigDecimal totalPrizeMoney = BigDecimal.ZERO;
        BigDecimal purchaseAmount = new BigDecimal(money.amount());
        BigDecimal hundred = new BigDecimal(100);

        // 당첨 금액 계산
        for (LottoRank rank : prizeDetails.keySet()) {
            BigDecimal prizeMoney = new BigDecimal(rank.getPrizeMoney());
            BigDecimal winCount = new BigDecimal(prizeDetails.get(rank));
            totalPrizeMoney = totalPrizeMoney.add(prizeMoney.multiply(winCount));
        }

        //수익률 계산
        return new RateOfReturn(
                totalPrizeMoney.divide(purchaseAmount, 3, RoundingMode.HALF_UP)
                        .multiply(hundred)
                        .setScale(1, RoundingMode.HALF_UP)
        );
    }
}

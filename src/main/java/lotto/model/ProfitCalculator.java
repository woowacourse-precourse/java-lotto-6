package lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class ProfitCalculator {

    private final int lottoPrice;
    private final List<Integer> matchCounts;
    private final List<Integer> prizeMoneyList = List.of(5000, 50000, 1500000, 30000000, 2000000000); // 3, 4, 5, 5+보너스, 6개 일치하는 경우의 상금

    public ProfitCalculator(int lottoPrice, List<Integer> matchCounts) {
        this.lottoPrice = lottoPrice;
        this.matchCounts = matchCounts;
    }

    public BigDecimal calculateProfit() {
        // 상금 총액을 계산합니다.
        int totalPrize = 0;
        for (int i = 0; i < matchCounts.size(); i++) {
            totalPrize += matchCounts.get(i) * prizeMoneyList.get(i);
        }

        // 수익률을 계산합니다. 수익률 = (당첨금 / 사용금액) * 100
        BigDecimal profitRate = new BigDecimal(totalPrize)
                .divide(new BigDecimal(lottoPrice), 2, RoundingMode.HALF_EVEN)
                .multiply(new BigDecimal(100));

        // 소수점 둘째 자리에서 반올림합니다.
        return profitRate.setScale(2, RoundingMode.HALF_EVEN);
    }
}

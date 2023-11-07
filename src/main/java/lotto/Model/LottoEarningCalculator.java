package lotto.Model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LottoEarningCalculator {
    public static BigDecimal calculateEarningsRate(long totalPrizeMoney, int numberOfTickets, int lottoPrice) {
        // 총 상금을 BigDecimal로 변환
        BigDecimal totalPrizeMoneyBD = new BigDecimal(totalPrizeMoney);

        // 투자한 금액 계산
        BigDecimal investedMoneyBD = new BigDecimal((long)numberOfTickets * lottoPrice);

        // 수익률 계산 (총 상금 / 투자한 금액)
        BigDecimal earningRateBD = totalPrizeMoneyBD.divide(investedMoneyBD, 4, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(100));

        return earningRateBD;
    }
}

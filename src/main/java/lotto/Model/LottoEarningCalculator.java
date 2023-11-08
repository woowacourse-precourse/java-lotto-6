package lotto.Model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LottoEarningCalculator {
    public static BigDecimal calculateEarningsRate(long totalPrizeMoney, int numberOfTickets, int lottoPrice) {

        BigDecimal totalPrizeMoneyBD = new BigDecimal(totalPrizeMoney);
        BigDecimal investedMoneyBD = new BigDecimal((long)numberOfTickets * lottoPrice);

        BigDecimal earningRateBD = totalPrizeMoneyBD.divide(investedMoneyBD, 4, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(100));

        return earningRateBD.setScale(2, RoundingMode.HALF_UP);
    }
}

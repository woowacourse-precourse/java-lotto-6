package lotto.util;

import static lotto.service.LottoRank.FIFTH;
import static lotto.service.LottoRank.FIRST;
import static lotto.service.LottoRank.FOURTH;
import static lotto.service.LottoRank.SECOND;
import static lotto.service.LottoRank.THIRD;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProfitRateCalculator {
    public static String calculate(int firstPrizeCount, int secondPrizeCount, int thirdPrizeCount,
                                   int fourthPrizeCount, int fifthPrizeCount, int purchasedLottoCount) {

        long totalPrize = firstPrizeCount * FIRST.getPrize() + secondPrizeCount * SECOND.getPrize() +
                thirdPrizeCount * THIRD.getPrize() + fourthPrizeCount * FOURTH.getPrize() +
                fifthPrizeCount * FIFTH.getPrize();

        BigDecimal totalPrizeDecimal = new BigDecimal(totalPrize);
        BigDecimal multiple = new BigDecimal(100);
        BigDecimal profit = totalPrizeDecimal.divide(BigDecimal.valueOf(purchasedLottoCount),
                3, RoundingMode.HALF_EVEN).multiply(multiple).stripTrailingZeros();

        return profit.toPlainString();
    }
}

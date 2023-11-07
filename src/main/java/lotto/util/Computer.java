package lotto.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import lotto.domain.Rank;
import lotto.view.constants.Prize;

public class Computer {
    private static final int LOTTO_PRICE = 1000;
    private static final int DECIMAL_PLACE = 3;
    private static final String HUNDRED = "100";
    private static final BigDecimal PERCENT = new BigDecimal(HUNDRED);
    private static final BigDecimal FIFTH_PRIZE = Prize.getPrize(Prize.FIFTH_PRIZE);
    private static final BigDecimal FOURTH_PRIZE = Prize.getPrize(Prize.FOURTH_PRIZE);
    private static final BigDecimal THIRD_PRIZE = Prize.getPrize(Prize.THIRD_PRIZE);
    private static final BigDecimal SECOND_PRIZE = Prize.getPrize(Prize.SECOND_PRIZE);
    private static final BigDecimal FIRST_PRIZE = Prize.getPrize(Prize.FIRST_PRIZE);

    public static BigDecimal computeProfit(int ticketAmount, Rank rank) {
        BigDecimal purchase = new BigDecimal(String.valueOf(ticketAmount * LOTTO_PRICE));
        BigDecimal fifth = new BigDecimal(String.valueOf(rank.fifth()));
        BigDecimal fourth = new BigDecimal(String.valueOf(rank.fourth()));
        BigDecimal third = new BigDecimal(String.valueOf(rank.third()));
        BigDecimal second = new BigDecimal(String.valueOf(rank.second()));
        BigDecimal first = new BigDecimal(String.valueOf(rank.first()));

        BigDecimal totalPrize = computePrize(fifth, fourth, third, second, first);

        return PERCENT.multiply(totalPrize.divide(purchase, DECIMAL_PLACE, RoundingMode.HALF_UP));
    }

    private static BigDecimal computePrize(BigDecimal fifth, BigDecimal fourth, BigDecimal third, BigDecimal second,
                                           BigDecimal first) {
        return fifth.multiply(FIFTH_PRIZE).add(
                fourth.multiply(FOURTH_PRIZE).add(
                        third.multiply(THIRD_PRIZE).add(
                                second.multiply(SECOND_PRIZE).add(
                                        first.multiply(FIRST_PRIZE)))));
    }
}

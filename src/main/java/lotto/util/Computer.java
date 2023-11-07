package lotto.util;

import java.math.BigDecimal;
import java.math.MathContext;
import lotto.domain.Rank;

public class Computer {
    private static final String HUNDRED = "100";
    private static final BigDecimal PERCENT = new BigDecimal(HUNDRED);
    private static final BigDecimal FIFTH_PRIZE = Prize.getPrize(Prize.FIFTH_PRIZE);
    private static final BigDecimal FOURTH_PRIZE = Prize.getPrize(Prize.FOURTH_PRIZE);
    private static final BigDecimal THIRD_PRIZE = Prize.getPrize(Prize.THIRD_PRIZE);
    private static final BigDecimal SECOND_PRIZE = Prize.getPrize(Prize.SECOND_PRIZE);
    private static final BigDecimal FIRST_PRIZE = Prize.getPrize(Prize.FIRST_PRIZE);

    public static BigDecimal computeProfit(String purchaseAmount, Rank rank) {
        BigDecimal purchase = new BigDecimal(purchaseAmount);
        BigDecimal fifth = new BigDecimal(String.valueOf(rank.fifth()));
        BigDecimal fourth = new BigDecimal(String.valueOf(rank.fourth()));
        BigDecimal third = new BigDecimal(String.valueOf(rank.third()));
        BigDecimal second = new BigDecimal(String.valueOf(rank.second()));
        BigDecimal first = new BigDecimal(String.valueOf(rank.first()));

        BigDecimal totalPrize = fifth.multiply(FIFTH_PRIZE).add(
                fourth.multiply(FOURTH_PRIZE).add(
                        third.multiply(THIRD_PRIZE).add(
                                second.multiply(SECOND_PRIZE).add(
                                        first.multiply(FIRST_PRIZE)))));

        return PERCENT.multiply(totalPrize.divide(purchase, MathContext.UNLIMITED));
    }
}

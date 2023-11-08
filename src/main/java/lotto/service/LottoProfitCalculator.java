package lotto.service;

import java.util.List;

public class LottoProfitCalculator {

    public static final int PERCENTAGE_FACTOR = 100;
    public static final int ROUNDING_FACTOR = 10;
    public static final double DECIMAL_PLACE = 10.0;

    private static final int INITIAL_MONEY_SUM = 0;
    private static final int NO_WINNING = 0;
    private static final int FIRST_PRIZE_MONEY = 2000000000;
    private static final int SECOND_PRIZE_MONEY = 30000000;
    private static final int THIRD_PRIZE_MONEY = 1500000;
    private static final int FOURTH_PRIZE_MONEY = 50000;
    private static final int FIFTH_PRIZE_MONEY = 5000;

    private static final int[] PRIZE_MONEY = {NO_WINNING, FIRST_PRIZE_MONEY, SECOND_PRIZE_MONEY,
        THIRD_PRIZE_MONEY, FOURTH_PRIZE_MONEY, FIFTH_PRIZE_MONEY};

    public static double calculateLottoProfit(int purchaseAmount, List<Integer> lottoResult) {
        double prizeMoneySum = INITIAL_MONEY_SUM;

        for (int i = 0; i < lottoResult.size(); i++) {
            prizeMoneySum += (lottoResult.get(i) * PRIZE_MONEY[i]);
        }

        return Math.round(prizeMoneySum / purchaseAmount * PERCENTAGE_FACTOR * ROUNDING_FACTOR) / DECIMAL_PLACE;
    }

}

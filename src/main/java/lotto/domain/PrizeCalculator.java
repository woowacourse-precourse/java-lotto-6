package lotto.domain;

public class PrizeCalculator {

    private static final int PRIZE_MONEY_FIRST = 2000000000;
    private static final int PRIZE_MONEY_SECOND = 30000000;
    private static final int PRIZE_MONEY_THIRD = 1500000;
    private static final int PRIZE_MONEY_FOURTH = 50000;
    private static final int PRIZE_MONEY_FIFTH = 5000;


    public static double getRateOfReturn(WinningResult winningResult, Amount amount) {
        Integer prize = winningResult.getNumberOfFirst() * PRIZE_MONEY_FIRST
                + winningResult.getNumberOfSecond() * PRIZE_MONEY_SECOND
                + winningResult.getNumberOfThird() * PRIZE_MONEY_THIRD
                + winningResult.getNumberOfFourth() * PRIZE_MONEY_FOURTH
                + winningResult.getNumberOfFifth() * PRIZE_MONEY_FIFTH;

        return Math.round((((double) prize / (double) amount.getAmount()) * 10000.0)) / 100.0;
    }
}

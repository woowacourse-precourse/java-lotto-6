package lotto.domain;

public class ProfitCalculator {

    private static final int LOTTO_PRICE = 1000;

    private ProfitCalculator() {
    }

    public static String calculate(int priceSum, int lottoCount) {
        double profit = (double) priceSum / (lottoCount * LOTTO_PRICE) * 100;

        return String.format("%.1f", profit);
    }
}

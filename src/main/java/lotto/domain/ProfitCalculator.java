package lotto.domain;

public class ProfitCalculator {

    private static final int LOTTO_PRICE = 1000;
    private static final String ZERO_DIVISION_ERROR_MESSAGE = "[ERROR] 로또를 구매해야 수익률을 계산할 수 있습니다.";

    private ProfitCalculator() {
    }

    public static String calculate(int priceSum, int lottoCount) {
        validateLottoCount(lottoCount);
        double profit = (double) priceSum / (lottoCount * LOTTO_PRICE) * 100;

        return String.format("%.1f", profit);
    }

    private static void validateLottoCount(int lottoCount) {
        if (lottoCount == 0) {
            throw new IllegalArgumentException(ZERO_DIVISION_ERROR_MESSAGE);
        }
    }
}

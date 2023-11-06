package lotto.util;

public class ProfitCalculator {
    private static final int PERCENT = 100;
    public static float calculateLottoReturnRate(int totalCost, long totalPrize) {
        if (totalPrize == 0) {
            return 0f;
        }
        return (totalPrize / (float) totalCost) * PERCENT;
    }
}

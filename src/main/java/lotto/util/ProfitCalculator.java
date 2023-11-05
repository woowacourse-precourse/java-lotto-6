package lotto.util;

public class ProfitCalculator {
    public static float calculateLottoReturnRate(int totalCost, long totalPrize) {
        return (totalCost / totalPrize) * 100;
    }
}

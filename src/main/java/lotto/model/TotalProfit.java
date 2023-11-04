package lotto.model;

public class TotalProfit {
    private static final String TOTAL_PROFIT_EXCEPTION_FORMAT = "수익률은 %d보다 작을 수 없습니다.";
    private final static double ZERO = 0;
    private final double totalProfit;

    private TotalProfit(double totalProfit) {
        validate(totalProfit);
        this.totalProfit = totalProfit;
    }

    private void validate(double totalProfit) {
        if (isUnderZero(totalProfit)) {
            String exceptionMessage = String.format(TOTAL_PROFIT_EXCEPTION_FORMAT, ZERO);
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    private boolean isUnderZero(double totalProfit) {
        return totalProfit < ZERO;
    }

    public static TotalProfit from(double totalProfit) {
        return new TotalProfit(totalProfit);
    }

    public double getTotalProfit() {
        return totalProfit;
    }
}

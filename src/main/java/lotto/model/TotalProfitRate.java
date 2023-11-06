package lotto.model;

import java.util.Objects;

public class TotalProfitRate {
    private static final String TOTAL_PROFIT_RATE_EXCEPTION_FORMAT = "총 수익률은 %f 이상이어야 합니다.";
    private final static double ZERO = 0.0;
    private final double profitRate;

    private TotalProfitRate(double profitRate) {
        validateUnderZero(profitRate);
        this.profitRate = profitRate;
    }

    private void validateUnderZero(double profitRate) {
        if (isUnderZero(profitRate)) {
            String exceptionMessage = String.format(TOTAL_PROFIT_RATE_EXCEPTION_FORMAT, ZERO);
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    private boolean isUnderZero(double profitRate) {
        return profitRate < ZERO;
    }

    public static TotalProfitRate from(double profitRate) {
        return new TotalProfitRate(profitRate);
    }

    public double getProfitRate() {
        return profitRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TotalProfitRate that = (TotalProfitRate) o;
        return Double.compare(profitRate, that.profitRate) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(profitRate);
    }
}

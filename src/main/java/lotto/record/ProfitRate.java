package lotto.record;

import static lotto.enumerate.ErrorCode.PROFIT_RATE_DECIMAL_NOT_ONE;
import static lotto.enumerate.ErrorCode.PROFIT_RATE_NOT_ROUNDED;

import lotto.util.ExceptionCodeThrow;

public record ProfitRate(double originalRate, double roundedRate) {
    public ProfitRate {
        if (Math.round(originalRate) != roundedRate) {
            ExceptionCodeThrow.exceptionCodeThrow(PROFIT_RATE_NOT_ROUNDED);
        }
        String formattedValue = String.format("%.2f", roundedRate);
        int decimalPlaces = formattedValue.length() - formattedValue.indexOf('.') - 1;

        if (decimalPlaces > 1) {
            ExceptionCodeThrow.exceptionCodeThrow(PROFIT_RATE_DECIMAL_NOT_ONE);
        }
    }
}

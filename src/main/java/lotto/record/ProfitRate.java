package lotto.record;

import static lotto.enumerate.ErrorCode.PROFIT_RATE_DECIMAL_NOT_ONE;
import static lotto.enumerate.ErrorCode.PROFIT_RATE_NOT_ROUNDED;
import static lotto.enumerate.Message.PROFIT_RATE_IS;

import lotto.util.ExceptionCodeThrow;

public record ProfitRate(double originalRate, double roundedRate) {
    private static final int PERCENT = 100;
    private static final int DECIMAL_PLACE = 1;
    public ProfitRate {
        if (originalRate * PERCENT != roundedRate) {
            ExceptionCodeThrow.exceptionCodeThrow(PROFIT_RATE_NOT_ROUNDED);
        }
        String formattedValue = String.format("%%.%df".formatted(DECIMAL_PLACE), roundedRate);
        int decimalPlaces = formattedValue.length() - formattedValue.indexOf('.') - DECIMAL_PLACE;

        if (decimalPlaces > DECIMAL_PLACE) {
            ExceptionCodeThrow.exceptionCodeThrow(PROFIT_RATE_DECIMAL_NOT_ONE);
        }
    }
    public String printProfitRate() {
        return String.format(PROFIT_RATE_IS.getMessage(), roundedRate);
    }
}

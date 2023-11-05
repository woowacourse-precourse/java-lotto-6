package lotto.record;

import static lotto.enumerate.ConfigInteger.DECIMAL_PLACE;
import static lotto.enumerate.ConfigInteger.LONG_ROUND_DIVIDE_NUMBER;
import static lotto.enumerate.ConfigString.STRING_FORMAT;
import static lotto.enumerate.ConfigString.STRING_INDEX;
import static lotto.enumerate.ErrorCode.PROFIT_RATE_DECIMAL_NOT_ONE;
import static lotto.enumerate.ErrorCode.PROFIT_RATE_NOT_ROUNDED;
import static lotto.enumerate.Message.PROFIT_RATE_IS;

import lotto.util.ExceptionCodeThrow;

public record ProfitRate(double originalRate, double roundedRate) {

    public ProfitRate {
        if (originalRate * LONG_ROUND_DIVIDE_NUMBER.getInt() != roundedRate) {
            ExceptionCodeThrow.exceptionCodeThrow(PROFIT_RATE_NOT_ROUNDED);
        }
        String formattedValue = String.format(STRING_FORMAT.getString().formatted(DECIMAL_PLACE.getInt()), roundedRate);
        int decimalPlaces = formattedValue.length() - formattedValue.indexOf(STRING_INDEX.getString()) - DECIMAL_PLACE.getInt();

        if (decimalPlaces > DECIMAL_PLACE.getInt()) {
            ExceptionCodeThrow.exceptionCodeThrow(PROFIT_RATE_DECIMAL_NOT_ONE);
        }
    }
    public String printProfitRate() {
        return String.format(PROFIT_RATE_IS.getMessage(), roundedRate);
    }
}

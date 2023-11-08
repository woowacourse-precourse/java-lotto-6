package lotto.exception;

import static lotto.exception.MoneyErrorMessage.*;

public class MoneyException {

    public static class MoneyUnitException extends IllegalArgumentException {
        public MoneyUnitException() {
            super(MONEY_UNIT_ERROR.toString());
        }
    }

    public static class MoneyZeroException extends IllegalArgumentException {
        public MoneyZeroException() {
            super(MONEY_ZERO_ERROR.toString());
        }
    }

    public static class MoneyFormatException extends IllegalArgumentException {
        public MoneyFormatException() {
            super(MONEY_FORMAT_ERROR.toString());
        }
    }
}

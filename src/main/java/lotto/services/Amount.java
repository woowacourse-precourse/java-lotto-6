package lotto.services;

import static lotto.exception.ExceptionHandler.invalidPriceType;
import static lotto.exception.ExceptionHandler.notDivisibleBy1000;
import static lotto.utils.Utils.stringToInteger;

public class Amount {

    public int createAmount(String amount) {
        validateAmountNotNumeric(amount);
        validateAmountNotDivisible(amount);

        return stringToInteger(amount);
    }

    private void validateAmountNotNumeric(String amount) {
        if (!isInvalidPrice(amount)) {
            invalidPriceType();
            throw new IllegalArgumentException();
        }
    }

    private boolean isInvalidPrice(String amount) {
        return amount.matches("^[0-9]*$");
    }

    private void validateAmountNotDivisible(String amount) {
        int convert = stringToInteger(amount);

        if (convert % 1000 != 0) {
            notDivisibleBy1000();
        }
    }
}

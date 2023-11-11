package lotto.validator;

import static lotto.constants.ExceptionMessages.CATCH_ERROR;
import static lotto.constants.ExceptionMessages.INPUT_EMPTY;
import static lotto.constants.ExceptionMessages.INVALID_NUMBER;
import static lotto.constants.ExceptionMessages.INVALID_PAYMENT;

public class PaymentValidator {
    private static final int PRICE_OF_LOTTO = 1000;

    public static int validate(String text) {
        checkNull(text);
        int payment = toInt(text);
        checkDividedByLottoPrice(payment);
        return payment;
    }

    private static int toInt(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(CATCH_ERROR + INVALID_NUMBER);
        }
    }

    private static void checkDividedByLottoPrice(int payment) {
        if (payment % PRICE_OF_LOTTO != 0) {
            throw new IllegalArgumentException(CATCH_ERROR + INVALID_PAYMENT);
        }
    }

    private static void checkNull(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException(CATCH_ERROR + INPUT_EMPTY);
        }
    }
}

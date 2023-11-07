package lotto.view;

import static lotto.utils.ErrorMessages.INPUT_NUMBER_FORMAT;
import static lotto.utils.ErrorMessages.PAYMENT_OVER_1000_UNIT;

public class InputValidator {

    public static int calculateTicketCount(int payment) {
        if (payment % 1000 != 0) throw new IllegalArgumentException(PAYMENT_OVER_1000_UNIT);
        return payment / 1000;
    }

    public static int parsePayment(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(INPUT_NUMBER_FORMAT);
        }
    }
}

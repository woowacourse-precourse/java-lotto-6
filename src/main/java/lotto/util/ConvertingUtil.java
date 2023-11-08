package lotto.util;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;
import lotto.validator.PriceValidator;

public class ConvertingUtil {
    private static final Integer TICKET_PRICE = 1000;

    public static int convertToTicket(String userInput) {
        PriceValidator.validatePrice(
                convertToInteger(userInput)
        );

        return convertToInteger(userInput) / TICKET_PRICE;
    }

    public static int convertToInteger(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new LottoException(ErrorMessage.NON_NUMERIC_VALUE);
        }
    }
}

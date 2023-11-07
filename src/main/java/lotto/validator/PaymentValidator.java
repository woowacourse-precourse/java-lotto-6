package lotto.validator;

import lotto.utils.constant.Error;

import java.util.regex.Pattern;

public class PaymentValidator {
    private static final Pattern MONEY_REGEX = Pattern.compile("^[0-9]*$");

    public static void validate(String input) {
        validateNumeric(input);
        validatePurchaseUnit(input);
    }

    private static void validateNumeric(String input) {
        if(!MONEY_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(Error.ERROR_PAYMENT_NOT_INTEGER);
        }
    }

    private static void validatePurchaseUnit(String input) {
        if(Integer.parseInt(input) % 1000 != 0) {
            throw new IllegalArgumentException(Error.ERROR_PAYMENT_PURCHASE_UNIT);
        }
    }
}

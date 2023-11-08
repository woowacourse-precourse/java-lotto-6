package lotto.validator;

import lotto.constant.ErrorConstant;
import lotto.constant.ValidatorConstant;
import lotto.utils.FormatUtils;

import java.util.regex.Pattern;

public class PaymentValidator {
    private static final Pattern MONEY_REGEX = Pattern.compile(ValidatorConstant.MONEY_REGEX);

    public static void validate(String input) {
        validateNumeric(input);
        validatePurchaseUnit(input);
    }

    private static void validateNumeric(String input) {
        if(!MONEY_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorConstant.ERROR_PAYMENT_NOT_INTEGER);
        }
    }

    private static void validatePurchaseUnit(String input) {
        if(FormatUtils.stringToInteger(input) % ValidatorConstant.VALIDATE_TICKET_PRICE != ValidatorConstant.MODULUS_VALUE) {
            throw new IllegalArgumentException(ErrorConstant.ERROR_PAYMENT_PURCHASE_UNIT);
        }
    }
}

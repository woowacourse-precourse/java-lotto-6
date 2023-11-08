package lotto.Validator;

import lotto.constant.ConfigurationNumbers;
import lotto.constant.ExceptionMessage;

public class PayValidator {
    public static void lessThanPrice(int num) {
        if (num < ConfigurationNumbers.PRICE.getNumber()) {
            throw new IllegalArgumentException(ExceptionMessage.LESS_THAN_PRICE.getMessage());
        }
    }

    public static void divisibleByPrice(int num) {
        if (num % ConfigurationNumbers.PRICE.getNumber() != 0) {
            throw new IllegalArgumentException(ExceptionMessage.CAN_NOT_DIVIDE.getMessage());
        }
    }
}

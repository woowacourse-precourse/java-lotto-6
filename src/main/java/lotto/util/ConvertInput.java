package lotto.util;

import static lotto.exception.ErrorMessage.PURCHASE_AMOUNT_HAS_MORE_THAN_ONE_VALUE;
import static lotto.exception.ErrorMessage.PURCHASE_AMOUNT_IS_NOT_NUMBER;
import static lotto.constraint.CommonConstraint.DELIMITER;

import lotto.exception.Exception;

public class ConvertInput {
    private ConvertInput() {
    }

    public static int makePlayerMoneyToInt(String input) {
        try {
            validateCount(input);
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw Exception.from(PURCHASE_AMOUNT_IS_NOT_NUMBER);
        }
    }

    private static void validateCount(String input) {
        if(!hasOnlyOneValue(input)){
            throw Exception.from(PURCHASE_AMOUNT_HAS_MORE_THAN_ONE_VALUE);
        }
    }

    private static boolean hasOnlyOneValue(String input){
        return !input.contains(DELIMITER.getValue());
    }
}
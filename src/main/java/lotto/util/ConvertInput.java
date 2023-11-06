package lotto.util;

import static lotto.exception.ErrorMessage.PURCHASE_AMOUNT_HAS_MORE_THAN_ONE_VALUE;
import static lotto.exception.ErrorMessage.PURCHASE_AMOUNT_IS_NOT_NUMBER;
import static lotto.exception.ErrorMessage.LOTTO_NUMBER_HAS_NOT_NUMBER_FORMAT;
import static lotto.constraint.CommonConstraint.DELIMITER;

import lotto.exception.Exception;

import java.util.Arrays;
import java.util.List;

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

    public static List<Integer> makeLottoNumberToList(String input) {
        try {
            return Arrays.stream(input.split(DELIMITER.getValue()))
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException exception) {
            throw Exception.from(LOTTO_NUMBER_HAS_NOT_NUMBER_FORMAT);
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
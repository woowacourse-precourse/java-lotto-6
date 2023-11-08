package lotto.util;

import static lotto.exception.ErrorMessage.PURCHASE_AMOUNT_HAS_MORE_THAN_ONE_VALUE;
import static lotto.exception.ErrorMessage.PURCHASE_AMOUNT_IS_NOT_NUMBER;
import static lotto.exception.ErrorMessage.LOTTO_NUMBER_HAS_NOT_NUMBER_FORMAT;
import static lotto.exception.ErrorMessage.BONUS_NUMBER_HAS_MORE_THAN_ONE_VALUE;
import static lotto.exception.ErrorMessage.BONUS_NUMBER_IS_NOT_NUMBER;
import static lotto.constraint.CommonConstraint.DELIMITER;

import lotto.exception.InputException;

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
            throw InputException.from(PURCHASE_AMOUNT_IS_NOT_NUMBER);
        }
    }

    public static List<Integer> makeLottoNumberToList(String input) {
        try {
            return Arrays.stream(input.split(DELIMITER.getValue()))
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException exception) {
            throw InputException.from(LOTTO_NUMBER_HAS_NOT_NUMBER_FORMAT);
        }
    }

    public static int makeBonusNumberToInt(String input) {
        try {
            validateCountBonusNumber(input);
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw InputException.from(BONUS_NUMBER_IS_NOT_NUMBER);
        }
    }

    private static void validateCount(String input) {
        if (!hasOnlyOneValue(input)) {
            throw InputException.from(PURCHASE_AMOUNT_HAS_MORE_THAN_ONE_VALUE);
        }
    }

    private static boolean hasOnlyOneValue(String input) {
        return !input.contains(DELIMITER.getValue());
    }

    private static void validateCountBonusNumber(String input) {
        if (!hasOnlyOneValue(input)) {
            throw InputException.from(BONUS_NUMBER_HAS_MORE_THAN_ONE_VALUE);
        }
    }
}
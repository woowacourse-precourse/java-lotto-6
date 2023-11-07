package lotto.validator;

import static lotto.validator.constants.ErrorType.*;
import static lotto.validator.constants.RangeType.PRIZE_NUMBER_MAX_RANGE;
import static lotto.validator.constants.RangeType.PRIZE_NUMBER_MIN_RANGE;
import static lotto.validator.constants.RegexType.REMOVE_WHITE_SPACE_REGEX;
import static lotto.validator.constants.RegexType.SPLIT_DELIMITER;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;

public class InputValidator {
    private static final int DIVISION_UNIT = 1000;

    public static int validateAmount(String amount) {
        int validateAmount = validateStringToInteger(amount);
        validateAmountFormat(validateAmount);
        return validateAmount;
    }

    public static Lotto validatePrizeNumbers(String prizeNumbers) {
        prizeNumbers = removeAllWhiteSpace(prizeNumbers);
        return new Lotto(parsePrizeNumbers(prizeNumbers));
    }

    private static int validateStringToInteger(String amount) {
        try {
            return Integer.parseInt(amount);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(CAN_NOT_CONVERT_INTEGER.getErrorMessage());
        }
    }

    private static void validateAmountFormat(int amount) {
        if (amount % DIVISION_UNIT != 0) {
            throw new IllegalArgumentException(CAN_NOT_SATISFY_INTEGER_CONDITION.getErrorMessage());
        }
    }

    private static String removeAllWhiteSpace(String prizeNumbers) {
        return prizeNumbers.replaceAll(REMOVE_WHITE_SPACE_REGEX.getRegex(), "");
    }

    private static List<Integer> parsePrizeNumbers(String prizeNumbers) {
        List<Integer> numbers = Arrays.stream(prizeNumbers.split(SPLIT_DELIMITER.getRegex()))
                .map(number -> validatePrizeNumberRange(Integer.parseInt(number)))
                .toList();
        return numbers;
    }

    private static int validatePrizeNumberRange(int number) {
        if (number < PRIZE_NUMBER_MIN_RANGE.getRange() || number > PRIZE_NUMBER_MAX_RANGE.getRange()) {
            throw new IllegalArgumentException(NUMBER_OVER_MAX_OR_MIN_RANGE.getErrorMessage());
        }
        return number;
    }
}

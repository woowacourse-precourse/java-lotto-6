package lotto.validator;

import static lotto.constants.ErrorType.*;
import static lotto.constants.RangeType.PRIZE_NUMBER_MAX_RANGE;
import static lotto.constants.RangeType.PRIZE_NUMBER_MIN_RANGE;
import static lotto.constants.RegexType.*;

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

    public static int validateBonusNumber(String bonusNumber) {
        int validateBonusNumber = validateStringToInteger(bonusNumber);
        validateBonusNumberRange(validateBonusNumber);
        return validateBonusNumber;
    }

    private static int validateStringToInteger(String amount) {
        try {
            return Integer.parseInt(amount);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(CAN_NOT_CONVERT_INTEGER.getErrorMessage());
        }
    }

    private static void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < PRIZE_NUMBER_MIN_RANGE.getRange() || bonusNumber > PRIZE_NUMBER_MAX_RANGE.getRange()) {
            throw new IllegalArgumentException(NUMBER_OVER_MAX_OR_MIN_RANGE.getErrorMessage());
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
        try {
            List<Integer> numbers = convertStringToInteger(prizeNumbers);
            return numbers;
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(CAN_NOT_CONVERT_INTEGER.getErrorMessage());
        }
    }

    private static List<Integer> convertStringToInteger(String prizeNumbers) {
        List<Integer> numbers = Arrays.stream(prizeNumbers.split(SPLIT_DELIMITER.getRegex()))
                .map(number -> Integer.parseInt(number))
                .toList();
        return numbers;
    }
}

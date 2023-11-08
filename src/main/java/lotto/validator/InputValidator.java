package lotto.validator;

import java.util.Arrays;
import lotto.exception.input.HasSpaceException;
import lotto.exception.input.NotIntegerException;
import lotto.exception.input.NullInputException;

public class InputValidator {
    // 입력값 형식 검증
    private static final String SPACE = " ";
    private static final String SPLIT_DELIMITER = ",";

    public static void validateInputBudgetType(String input) {
        validateNull(input);
        validateHasNoSpace(input);
        validateInteger(input);
    }

    public static void validateInputNumbersType(String input) {
        validateNull(input);
        validateHasNoSpace(input);
        validateIntegerNumbers(input);
    }

    public static void validateBonusNumberType(String input) {
        validateNull(input);
        validateHasNoSpace(input);
        validateInteger(input);
    }

    private static void validateIntegerNumbers(String input) {
        boolean allIntegers = allIntegers(input);
        if (!allIntegers) {
            throw new NotIntegerException();
        }
    }

    private static void validateInteger(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new NotIntegerException();
        }
    }

    private static void validateNull(String input) {
        if (input == null || input.isBlank()) {
            throw new NullInputException();
        }
    }

    private static void validateHasNoSpace(String input) {
        if (input.contains(SPACE)) {
            throw new HasSpaceException();
        }
    }

    private static boolean allIntegers(String input) {
        return Arrays.stream(input.split(SPLIT_DELIMITER))
                .allMatch(part -> {
                    try {
                        Integer.parseInt(part);
                        return true;
                    } catch (NumberFormatException e) {
                        return false;
                    }
                });
    }
}

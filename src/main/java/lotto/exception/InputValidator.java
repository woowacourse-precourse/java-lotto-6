package lotto.exception;

import static lotto.exception.ExceptionMessage.COUNT_EXCEPTION;
import static lotto.exception.ExceptionMessage.DUPLICATION_EXCEPTION;
import static lotto.exception.ExceptionMessage.RANGE_EXCEPTION;
import static lotto.exception.ExceptionMessage.NON_NUMBER_EXCEPTION;
import static lotto.exception.ExceptionMessage.INVALID_AMOUNT_FORMAT;

import java.util.HashSet;
import java.util.List;

public class InputValidator {

    public static boolean validateWinningNumInput(List<Integer> winningNums) {

        validateNumSize(winningNums);
        hasDuplicates(winningNums);

        for (Integer number : winningNums) {
            validateInputRange(number);
        }
        return true;
    }

    public static boolean validateBonusNumInput(String bonusNum) {
        validateStringInput(bonusNum);
        validateStrInputRange(bonusNum);

        return true;
    }

    public static boolean validatePurchaseAmountInput(String input) {
        if (input == null || !input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException(NON_NUMBER_EXCEPTION.getMessage());
        }
        isMultipleOf1000(input);

        return true;
    }

    public static void validateNumSize(List<Integer> input) {
        if (input.size() != 6) {
            throw new IllegalArgumentException(COUNT_EXCEPTION.getMessage());
        }

    }

    public static void hasDuplicates(List<Integer> winningNums) {
        HashSet<Integer> set = new HashSet<>();
        for (Integer number : winningNums) {
            if (!set.add(number)) {
                throw new IllegalArgumentException(DUPLICATION_EXCEPTION.getMessage());
            }
        }
    }

    public static void validateStrInputRange(String input) {
        if (!input.matches("^[1-9]|[1-3][0-9]|4[0-5]$")) {
            throw new IllegalArgumentException(RANGE_EXCEPTION.getMessage());
        }
    }


    public static void validateInputRange(int input) {
        if (input < 1 || input > 45) {
            throw new IllegalArgumentException(RANGE_EXCEPTION.getMessage());
        }
    }

    public static void validateStringInput(String input) {
        if (input == null || !input.matches("^[0-9,]+$")) {
            throw new IllegalArgumentException(NON_NUMBER_EXCEPTION.getMessage());
        }
    }

    public static void isMultipleOf1000(String input) {
        int num = Integer.parseInt(input);
        if (num % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_AMOUNT_FORMAT.getMessage());
        }
    }
}

package lotto.validator;

import static lotto.validator.ExceptionMessages.BONUS_NUMBER_DUPLICATE;
import static lotto.validator.ExceptionMessages.DUPLICATE_NUMBERS;
import static lotto.validator.ExceptionMessages.INCORRECT_COUNT;
import static lotto.validator.ExceptionMessages.INVALID_INPUT;
import static lotto.validator.ExceptionMessages.INVALID_PURCHASE_AMOUNT;
import static lotto.validator.ExceptionMessages.NON_NUMERIC_INPUT;
import static lotto.validator.ExceptionMessages.OUT_OF_RANGE;

import java.util.Arrays;
import java.util.List;

public class Validator {

    public static void validatePurchaseAmount(String input) {
        validateNumericInput(input);
        int purchaseAmount = Integer.parseInt(input);
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT.getErrorMessage());
        }
    }

    public static void validateWinningNumbers(String input) {
        validateInputForm(input);

        List<String> winningNumbers = Arrays.asList(input.split(","));
        validateInputCount(winningNumbers);
        validateDuplicate(winningNumbers);

        for (String value : winningNumbers) {
            validateNumericInput(value);
            validateInputRange(value);
        }
    }

    public static void validateBonusNumber(List<Integer> winningNumbers, String input) {
        validateNumericInput(input);
        validateInputRange(input);
        if (winningNumbers.contains(Integer.parseInt(input))) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE.getErrorMessage());
        }
    }

    private static void validateNumericInput(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_NUMERIC_INPUT.getErrorMessage());
        }
    }

    private static void validateInputForm (String input) {
        if (input.startsWith(",") || input.endsWith(",")) {
            throw new IllegalArgumentException(INVALID_INPUT.getErrorMessage());
        }
    }

    private static void validateInputRange (String input) {
        if (1 > Integer.parseInt(input) || 45 < Integer.parseInt(input)) {
            throw new IllegalArgumentException(OUT_OF_RANGE.getErrorMessage());
        }
    }

    private static void validateInputCount(List<String> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(INCORRECT_COUNT.getErrorMessage());
        }
    }

    private static void validateDuplicate(List<String> winningNumbers) {
        if (winningNumbers.size() != winningNumbers.stream().distinct().count()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBERS.getErrorMessage());
        }
    }
}


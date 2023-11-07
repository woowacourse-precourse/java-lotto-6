package lotto.controller;

import static lotto.util.Constants.MAX_RANGE;
import static lotto.util.Constants.MIN_RANGE;
import static lotto.util.ErrorConstants.OVER_RANGE;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Lotto;
import lotto.util.Constants;
import lotto.util.ErrorConstants;

public class InputValidator {
    private static final String COMMA_SEPARATED_SIX_NUMBERS_REGEX = "^(\\d+,){5}\\d+$";

    private static void inputIsBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorConstants.BLANK);
        }
    }

    private static int isInteger(String input) {
        inputIsBlank(input);
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorConstants.OVER_INTEGER);
        }
    }

    private static void isThousandUnit(int amount) {
        if (amount < Constants.LOTTO_PRICE || amount % Constants.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorConstants.THOUSAND_UNIT);
        }
    }

    private static void isNumberInRange(int number) {
        if (number < MIN_RANGE || number > MAX_RANGE) {
            throw new IllegalArgumentException(OVER_RANGE);
        }
    }

    private static void containsNumber(int target, List<Integer> numbers) {
        if (numbers.contains(target)) {
            throw new IllegalArgumentException(ErrorConstants.DUPLICATE_NUMBER);
        }
    }

    private static void isCommaSeparated(String input) {
        if (!input.matches(COMMA_SEPARATED_SIX_NUMBERS_REGEX)) {
            throw new IllegalArgumentException(ErrorConstants.INADEQUATE_INPUT);
        }
    }

    public static int validatePurchaseAmount(String input) {
        int amount = isInteger(input);
        isThousandUnit(amount);
        return amount;
    }

    public static List<Integer> validateWinningNumbers(String input) {
        isCommaSeparated(input);
        List<Integer> result = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(InputValidator::isInteger)
                .collect(Collectors.toList());
        Lotto.validate(result);
        return result;
    }

    public static int validateBonusNumber(String bonusNumber, List<Integer> winningNumbers) {
        int bonus = isInteger(bonusNumber);
        isNumberInRange(bonus);
        containsNumber(bonus, winningNumbers);
        return bonus;
    }
}
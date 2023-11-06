package lotto;

import java.util.List;

import static lotto.error.ErrorMessage.*;

public class GlobalValidator {

    public static void validatePurchaseAmount(String input) {
        isDigit(input);
        isDividedByThousand(input);
    }

    private static void isDigit(String input) {
        try {
            Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_NOT_DIGIT.getMessage());
        }
    }

    private static void isDividedByThousand(String input) {
        if (!input.endsWith("000")) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }

    public static void validateWinningNumber(List<String> winningNumber) {
        winningNumber.forEach(GlobalValidator::isDigit);
        hasDuplicateNumber(winningNumber);
    }

    private static void hasDuplicateNumber(List<String> winningNumber) {
        List<String> duplicateRemoved = winningNumber.stream()
                .distinct()
                .toList();
        if (duplicateRemoved.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE.getMessage());
        }
    }

    private static void isNumberInRange(List<String> winningNumber) {
    }

    public static void validateBonusNumber(List<Integer> winningNumber, String input) {
        isDigit(input);
        isBonusNumberInWinningNumber(Integer.parseInt(input), winningNumber);
    }

    private static void isBonusNumberInWinningNumber(Integer input,
                                                     List<Integer> winningNumber) {
        if (winningNumber.contains(input)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE.getMessage());
        }
    }
}
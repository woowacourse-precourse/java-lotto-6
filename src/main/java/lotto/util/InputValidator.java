package lotto.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import lotto.model.Constants;

public class InputValidator {

    public static void validatePurchaseAmount(String purchaseAmount) {
        validateIsNumber(purchaseAmount);

        validateLessThanThousand(purchaseAmount);
        validateDivisibilityByThousand(purchaseAmount);
    }

    public static void validateWinningNumbers(String undividedWinningNumbers) {
        String[] dividedWinningNumbers = undividedWinningNumbers.split(",");

        validateIsNumber(dividedWinningNumbers);
        validateNumberRange(dividedWinningNumbers);
        validateNumberOfWinningNumbers(dividedWinningNumbers);
        validateNoDuplicateWinningNumbers(dividedWinningNumbers);
    }

    public static void validateBonusNumber(List<Integer> winningNumbers, String bonusNumber) {
        validateIsNumber(bonusNumber);

        validateNumberRange(bonusNumber);
        validateBonusNumberNotUsed(winningNumbers, bonusNumber);
    }

    private static void validateIsNumber(String beforeValidation) {
        for (int i = 0; i < beforeValidation.length(); i++) {
            if (!Character.isDigit(beforeValidation.charAt(i))) {
                throw new IllegalArgumentException(Constants.NOT_NUMBER);
            }
        }
    }

    private static void validateIsNumber(String[] beforeValidations) {
        for (String beforeValidation : beforeValidations) {
            validateIsNumber(beforeValidation);
        }
    }

    private static void validateNumberRange(String beforeValidation) {
        int number = Integer.parseInt(beforeValidation);
        if (number < Constants.MIN_NUMBER || number > Constants.MAX_NUMBER) {
            throw new IllegalArgumentException(Constants.OUT_OF_RANGE);
        }
    }

    private static void validateNumberRange(String[] beforeValidations) {
        for (String beforeValidation : beforeValidations) {
            validateNumberRange(beforeValidation);
        }
    }

    private static void validateLessThanThousand(String beforeValidation) {
        int purchaseAmount = Integer.parseInt(beforeValidation);
        if (purchaseAmount < Constants.THOUSAND) {
            throw new IllegalArgumentException(Constants.LESS_THAN_THOUSAND);
        }
    }

    private static void validateDivisibilityByThousand(String beforeValidation) {
        int purchaseAmount = Integer.parseInt(beforeValidation);
        if (purchaseAmount % Constants.THOUSAND != Constants.ZERO) {
            throw new IllegalArgumentException(Constants.NOT_DIVISIBLE_BY_THOUSAND);
        }
    }

    private static void validateNumberOfWinningNumbers(String[] beforeValidations) {
        if (beforeValidations.length != Constants.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(Constants.NOT_SIX_WINNING_NUMBERS);
        }
    }

    private static void validateNoDuplicateWinningNumbers(String[] beforeValidations) {
        HashSet<String> distinct = new HashSet<>(Arrays.asList(beforeValidations));
        if (distinct.size() != Constants.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(Constants.DUPLICATE_WINNING_NUMBERS);
        }
    }

    private static void validateBonusNumberNotUsed(List<Integer> winningNumbers, String bonusNumber) {
        if (winningNumbers.contains(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException(Constants.ALREADY_USED_WINNING_NUMBER);
        }
    }

}

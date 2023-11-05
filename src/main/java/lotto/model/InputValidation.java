package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.constants.ErrorMessage;

public class InputValidation {
    public static int validatePurchaseAmount(String input) {
        if (!input.matches("[1-9]\\d*")) {
            validateNegativePurchase(input);
            validateZeroPurchase(input);
            throw new IllegalArgumentException(ErrorMessage.INVALID_NON_NUMERIC_PURCHASE.getMessage());
        }
        return Integer.parseInt(input);
    }

    public static List<Integer> validateWinningNumbers(String[] numbers) {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            try {
                int number = Integer.parseInt(numbers[i]);
                lottoNumbers.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_NON_NUMERIC.getMessage());
            }
        }
        return lottoNumbers;
    }

    public static int validateBonusNumber(String input) {
        try {
            int bonusNumber = Integer.parseInt(input);
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NON_NUMERIC_PURCHASE.getMessage());
        }
    }

    private static void validateNegativePurchase(String input) {
        if (input.matches("[-]\\d+")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NEGATIVE_PURCHASE.getMessage());
        }
    }

    private static void validateZeroPurchase(String input) {
        if (input.matches("0+")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ZERO_PURCHASE.getMessage());
        }
    }
}

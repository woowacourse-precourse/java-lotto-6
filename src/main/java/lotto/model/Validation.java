package lotto.model;

import java.util.List;
import lotto.constants.ErrorMessage;

public class Validation {
    public static void validatePurchaseAmount(String input) {
        if (!input.matches("[1-9]\\d*")) {
            handleInvalidNegativePurchase(input);
            handleInvalidZeroPurchase(input);
            throw new IllegalArgumentException(ErrorMessage.INVALID_NON_NUMERIC_PURCHASE.getMessage());
        }
    }

    public static int validatePurchaseAmountDivisible(String input) {
        int purchaseAmount = Integer.parseInt(input);
        handleInvalidAmountNotDivisible(purchaseAmount);
        return purchaseAmount;
    }

    public static void validateBonusNumber(String input, List<Integer> lottoNumbers) {
        try {
            int bonusNumber = Integer.parseInt(input);
            handleInvalidLottoNumber(bonusNumber);
            handleInvalidBonusDuplicate(lottoNumbers, bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NON_NUMERIC_PURCHASE.getMessage());
        }
    }

    private static void handleInvalidNegativePurchase(String input) {
        if (input.matches("[-]\\d+")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NEGATIVE_PURCHASE.getMessage());
        }
    }

    private static void handleInvalidZeroPurchase(String input) {
        if (input.matches("0+")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ZERO_PURCHASE.getMessage());
        }
    }

    private static void handleInvalidAmountNotDivisible(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT_NOT_DIVISIBLE.getMessage());
        }
    }

    private static void handleInvalidLottoNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER.getMessage());
        }
    }

    private static void handleInvalidBonusDuplicate(List<Integer> lottoNumbers, int bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_DUPLICATE.getMessage());
        }
    }
}

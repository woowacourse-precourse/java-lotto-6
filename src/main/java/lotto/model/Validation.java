package lotto.model;

import java.util.List;
import lotto.constants.ErrorMessage;

public class Validation {
    public static void validatePurchaseAmount(String input) {
        if (!input.matches("[1-9]\\d*")) {
            if (input.matches("[-]\\d+")) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_NEGATIVE_PURCHASE.getMessage());
            }
            if (input.matches("0+")) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_ZERO_PURCHASE.getMessage());
            }
            throw new IllegalArgumentException(ErrorMessage.INVALID_NON_NUMERIC_PURCHASE.getMessage());
        }
    }

    public static int validatePurchaseAmountDivisible(String input) {
        int purchaseAmount = Integer.parseInt(input);

        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT_NOT_DIVISIBLE.getMessage());
        }
        return purchaseAmount;
    }

    public static void validateBonusNumber(String input, List<Integer> lottoNumbers) {
        try {
            int bonusNumber = Integer.parseInt(input);
            if (bonusNumber < 1 || bonusNumber > 45) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER.getMessage());
            }
            if (lottoNumbers.contains(bonusNumber)) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_DUPLICATE.getMessage());
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NON_NUMERIC_PURCHASE.getMessage());
        }
    }
}

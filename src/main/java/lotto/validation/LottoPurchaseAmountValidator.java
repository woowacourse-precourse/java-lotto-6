package lotto.validation;

import java.util.regex.Pattern;
import lotto.error.ErrorMessage;

public class LottoPurchaseAmountValidator {

    private static final int LOTTO_PURCHASE_MINIMUM_AMOUNT = 1000;
    private static final String REGEXP_PATTERN_ZERO_TO_NINE_NUMBER = "^[0-9]*$";

    public static void validateLottoPurchaseAmount(String lottoPurchaseAmount) {
        if (!isOnlyInteger(lottoPurchaseAmount)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER_LOTTO_PURCHASE_AMOUNT.getMessage());
        }

        if (isStartZero(lottoPurchaseAmount)) {
            throw new IllegalArgumentException(ErrorMessage.START_ZERO_LOTTO_PURCHASE_AMOUNT.getMessage());
        }

        if (!isDividedByLottoPurchaseMinimumAmount(lottoPurchaseAmount)) {
            throw new IllegalArgumentException(
                    ErrorMessage.NOT_DIVIDE_LOTTO_PURCHASE_MINIMUM_AMOUNT.getMessage());
        }
    }

    private static boolean isOnlyInteger(String lottoPurchaseAmount) {
        return Pattern.matches(REGEXP_PATTERN_ZERO_TO_NINE_NUMBER, lottoPurchaseAmount);
    }

    private static boolean isStartZero(String lottoPurchaseAmount) {
        return lottoPurchaseAmount.charAt(0) == '0';
    }

    private static boolean isDividedByLottoPurchaseMinimumAmount(String lottoPurchaseAmount) {
        return Integer.parseInt(lottoPurchaseAmount) % LOTTO_PURCHASE_MINIMUM_AMOUNT == 0;
    }
}

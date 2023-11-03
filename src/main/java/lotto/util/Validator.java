package lotto.util;

import java.util.regex.Pattern;

public class Validator {
    static final Pattern puchaseAmountPattern = Pattern.compile("^[1-9]([1-9])*$");
    public static final String INPUT_ERROR_MESSAGE = "[ERROR] 1에서 45 사이의 숫자를 입력해 주세요.";

    public static boolean lottoPurchaseAmountValidator(String inputLottoPurchaseAmount) {
        return isValidPurchaseAmount(inputLottoPurchaseAmount);
    }

    private static boolean isValidPurchaseAmount(String inputLottoPurchaseAmount) {
        try {
            if (!puchaseAmountPattern.matcher(inputLottoPurchaseAmount).matches()) {
                throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
            }
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
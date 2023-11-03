package lotto.util;

import java.util.regex.Pattern;

public class Validator {
    private static final Pattern purchaseAmountPattern = Pattern.compile("^[1-9]([0-9])*[05]00$");
    private static final String PURCHASE_INPUT_ERROR_MESSAGE = "[ERROR] 1000원 단위의 양수를 입력해주세요";

    public static boolean lottoPurchaseAmountValidator(String inputLottoPurchaseAmount) {
        try {
            if (!purchaseAmountPattern.matcher(inputLottoPurchaseAmount).matches()) {
                throw new IllegalArgumentException(PURCHASE_INPUT_ERROR_MESSAGE);
            }
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
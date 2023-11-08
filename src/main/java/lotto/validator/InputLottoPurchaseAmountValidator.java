package lotto.validator;

import java.util.regex.Pattern;

public class InputLottoPurchaseAmountValidator {
    private static final String NON_INPUT_ERROR_MESSAGE = "[ERROR] 입력하지 않으셨습니다. 구입금액을 입력해주세요";
    private static final String NON_INTEGER_ERROR_MESSAGE = "[ERROR] 로또 구입금액은 숫자를 입력하셔야합니다.";
    private static final String NON_DIVIDE_1000_ERROR_MESSAGE = "[ERROR] 로또 구입금액은 1000원 단위입니다.";
    private static final String NON_OVER_ZERO_ERROR_MESSAGE = "[ERROR] 로또 구입금액은 0이상이여야 합니다.";
    private static final String inputPattern = "[0-9]+";
    private static final String BLANK = "";


    public void validateNonInputPurchaseAmount(String purchaseAmount) {
        if (purchaseAmount.equals(BLANK)) {
            throw new IllegalArgumentException(NON_INPUT_ERROR_MESSAGE);
        }
    }

    public void validateNonIntegerPurchaseAmount(String purchaseAmount) {
        if (!Pattern.matches(inputPattern, purchaseAmount)) {
            throw new IllegalArgumentException(NON_INTEGER_ERROR_MESSAGE);
        }
    }

    public void validateNonDivide1000PurchaseAmount(String purchaseAmount) {
        int lottoPurchaseAmount = Integer.parseInt(purchaseAmount);
        if (lottoPurchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(NON_DIVIDE_1000_ERROR_MESSAGE);
        }
    }

    public void validateNonOverZeroPurchaseAmount(String purchaseAmount) {
        int lottoPurchaseAmount = Integer.parseInt(purchaseAmount);
        if (lottoPurchaseAmount <= 0) {
            throw new IllegalArgumentException(NON_OVER_ZERO_ERROR_MESSAGE);
        }
    }
}

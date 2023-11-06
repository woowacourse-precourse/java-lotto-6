package lotto.validator;

import lotto.util.ConverterUtil;

public class InputPurchaseAmountValidator {
    private static final int MINIMUM_LOTTO_AMOUNT = 1000;

    public static void validatePurchaseAmount(String purchaseAmount) {
        if (isNotDigit(purchaseAmount)) {
            System.out.println("[ERROR] 숫자를 입력해야합니다.");
            throw new IllegalArgumentException();
        }
        if (isNotMultipleOf1000(purchaseAmount)) {
            System.out.println("[ERROR] 1,000원 단위의 숫자를 입력해야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    private static boolean isNotMultipleOf1000(String purchaseAmount) {
        return ConverterUtil.convertStringToInt(purchaseAmount) % MINIMUM_LOTTO_AMOUNT != 0;
    }

    private static boolean isNotDigit(String purchaseAmount) {
        try {
            int num = ConverterUtil.convertStringToInt(purchaseAmount);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }
}

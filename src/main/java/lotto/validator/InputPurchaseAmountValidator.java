package lotto.validator;

import java.util.regex.Pattern;
import lotto.util.ConverterUtil;

public class InputPurchaseAmountValidator {
    private static final int MINIMUM_LOTTO_AMOUNT = 1000;
    private static final long MAXIMUM_LOTTO_AMOUNT = Integer.MAX_VALUE;
    private static final String LOTTO_PURCHASE_NUMBER_REGEX = "[0-9]+";


    public static void validatePurchaseAmount(String purchaseAmount) {
        if (isNotDigit(purchaseAmount)) {
            throw new IllegalArgumentException(("[ERROR] 숫자를 입력해야 합니다."));
        }
        if (isOverMaximumAmount(purchaseAmount)) {
            throw new IllegalArgumentException("[ERROR] 2,147,483,647보다 작은 값을 입력해야 합니다.");
        }
        if (isNotMultipleOf1000(purchaseAmount)) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위의 숫자를 입력해야 합니다.");
        }
    }

    private static boolean isNotMultipleOf1000(String purchaseAmount) {
        return ConverterUtil.convertStringToInt(purchaseAmount) % MINIMUM_LOTTO_AMOUNT != 0;
    }

    private static boolean isNotDigit(String purchaseAmount) {
        return !Pattern.compile(LOTTO_PURCHASE_NUMBER_REGEX).matcher(purchaseAmount).matches();
    }

    private static boolean isOverMaximumAmount(String purchaseAmount) {
        return Long.parseLong(purchaseAmount) > MAXIMUM_LOTTO_AMOUNT;
    }
}

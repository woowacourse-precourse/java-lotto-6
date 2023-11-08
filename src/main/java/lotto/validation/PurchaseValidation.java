package lotto.validation;

import java.util.regex.Pattern;

public class PurchaseValidation {
    private static final String PRICE_PATTERN = "^[1-9][0-9]*$";

    public static void validatePriceFormat(String purchaseValue) {
        if (!Pattern.matches(PRICE_PATTERN, purchaseValue)) {
            throw new IllegalArgumentException("[ERROR] 자연수 형태의 값을 입력해주세요.");
        }
    }

    public static void validatePriceDividePossible(int purchasePossibleValue) {
        if (purchasePossibleValue % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000으로 나누어 떨어지는 수를 입력해주세요.");
        }
    }
}

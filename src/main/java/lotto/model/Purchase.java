package lotto.model;

import static lotto.util.Constants.*;

public class Purchase {

    private final int purchaseCount;

    private Purchase(int purchaseCount) {
        this.purchaseCount = purchaseCount;
    }

    public static Purchase fromPurchaseAmount(String input) {
        validateNumeric(input);
        int purchaseCount = calculatePurchaseCount(Integer.parseInt(input));
        return new Purchase(purchaseCount);
    }

    // 구매 금액에 따른 구매 개수 계산
    private static int calculatePurchaseCount(int purchaseAmount) {
        validateAmountInThousands(purchaseAmount);
        return purchaseAmount / PRICE_VALUE;
    }

    // 구매 금액이 1000원 단위인지 검증
    private static void validateAmountInThousands(int purchaseAmount) {
        if (purchaseAmount % PRICE_VALUE != DEFAULT_VALUE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_AMOUNT_NOT_IN_THOUSANDS);
        }
    }

    // 구매 금액이 숫자로만 이루어져있는지 검증
    private static void validateNumeric(String input) {
        if (!input.matches(NUMBER_PATTERN)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_AMOUNT_NUMERIC);
        }
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }
}

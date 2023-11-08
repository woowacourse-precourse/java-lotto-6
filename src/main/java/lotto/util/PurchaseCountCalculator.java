package lotto.util;

public class PurchaseCountCalculator {

    private static final String ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE = "[ERROR] 구매 금액은 %d원 단위여야 합니다. 다시 입력하세요.";

    private PurchaseCountCalculator() {
    }

    public static int calculatePurchaseCount(int purchaseAmount, int itemPrice) {
        validateRemainderIsZero(purchaseAmount, itemPrice);
        return purchaseAmount / itemPrice;
    }

    private static void validateRemainderIsZero(int purchaseAmount, int itemPrice) {
        int remainder = purchaseAmount % itemPrice;
        if (remainder != 0) {
            throw new IllegalArgumentException(
                ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE.formatted(itemPrice));
        }
    }
}

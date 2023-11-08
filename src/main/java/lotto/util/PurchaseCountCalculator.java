package lotto.util;

public class PurchaseCountCalculator {

    public static int calculatePurchaseCount(int purchaseAmount, int itemPrice) {
        validateRemainderIsZero(purchaseAmount, itemPrice);
        return purchaseAmount / itemPrice;
    }

    static void validateRemainderIsZero(int purchaseAmount, int itemPrice) {
        int remainder = purchaseAmount % itemPrice;
        if (remainder != 0) {
            throw new IllegalArgumentException();
        }
    }
}

package lotto.utils;

public class PurchaseManager {

    private static final int LOTTO_PRICE = 1000;

    public static int dividePurchaseAmount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }
}

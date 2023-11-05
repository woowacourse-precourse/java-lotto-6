package lotto.domain;

public class inputPurchaseAmount {
    public static boolean inputPurchaseAmount(String purchaseAmount) {
        try {
            Integer.parseInt(purchaseAmount);
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}

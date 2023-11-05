package lotto.domain;

public class inputPurchaseAmount {
    public static boolean inputPurchaseAmountInt(String purchaseAmount) {
        try {
            Integer.parseInt(purchaseAmount);
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}

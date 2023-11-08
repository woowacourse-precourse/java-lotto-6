package lotto.domain;

public class InputPurchaseAmount {
    public static void inputPurchaseAmountInt(String purchaseAmount) {
        try {
            Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void inputPurchaseAmountPositive(int purchaseAmount) {
        if (purchaseAmount < 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void inputPurchaseAmountDivisible1000(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}

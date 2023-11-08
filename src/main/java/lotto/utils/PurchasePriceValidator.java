package lotto.utils;

public class PurchasePriceValidator {
    public static void validIsInt(String purchasePrice) {
        try {
            Integer.parseInt(purchasePrice);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구매금액은 숫자여야 합니다.");
        }
    }

    public static void validIsMultiplesOfThousand(int purchasePrice) {
        if (purchasePrice%1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매금액은 1000으로 나누어 떨어져야 합니다.");
        }
    }
}

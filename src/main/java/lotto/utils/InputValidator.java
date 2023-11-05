package lotto.utils;

public class InputValidator {

    public static void validateAmountNotNumber(String purchaseAmount) {
        try {
            Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] : 로또 구입 금액은 정수입니다.");
        }
    }
}

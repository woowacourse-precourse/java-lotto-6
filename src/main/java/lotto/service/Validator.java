package lotto.service;

public class Validator {

    public static void validateAmount(String amount) {
        if (!isNumbers(amount)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자이어야 합니다.");
        }
        if (!isValidateAmount(amount)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000 단위이어야 합니다.");
        }
    }

    private static boolean isNumbers(String amount) {
        return amount.matches("\\d+");
    }

    private static boolean isValidateAmount(String amount) {
        return Integer.parseInt(amount) >= 0 || Integer.parseInt(amount) % 1000 == 0;
    }
}

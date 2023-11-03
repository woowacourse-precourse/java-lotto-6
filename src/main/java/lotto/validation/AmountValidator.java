package lotto.validation;

public class AmountValidator {

    private static int parseToInt(String amount) {
        try {
            return Integer.parseInt(amount);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 정수형 숫자만 입력할 수 있습니다.");
        }
    }

    private static void validatePositive(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 0보다 커야 합니다.");
        }
    }

    private static void validateThousandUnit(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위로 입력해야 합니다.");
        }
    }
}

package lotto.model;

public final class MoneyValidator {

    private MoneyValidator() {
    }

    public static void validateMoney(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 입력 금액은 1000원 단위여야 합니다.");
        }
    }
}

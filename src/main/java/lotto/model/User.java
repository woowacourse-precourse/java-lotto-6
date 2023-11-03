package lotto.model;

public class User {

    private static final int AMOUNT_UNIT = 1000;
    private static final int NO_AMOUNT = 0;
    private int amount;

    private User(int amount) {
        this.amount = amount;
    }

    public static User from(int amount) {
        validateAmountUnit(amount);
        validateIsZero(amount);
        return new User(amount);
    }

    private static void validateAmountUnit(int amount) {
        if (amount % AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원 단위여야 합니다.");
        }
    }

    private static void validateIsZero(int amount) {
        if (amount == NO_AMOUNT) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 0원 이상 입력해야 합니다.");
        }
    }
}

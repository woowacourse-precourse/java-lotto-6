package Model;

public class UserValidator {

    private static final int MIN_MONEY_RANGE = 1000;
    private static final int MAX_MONEY_RANGE = 1000000000;
    private static final int MONEY_MAX_LENGTH = 10;

    void validateMoneyLength(String money) {
        if (money.length() > MONEY_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    void validateMoneyInRange(int money) {
        if (money >= MIN_MONEY_RANGE && money <= MAX_MONEY_RANGE) {
            throw new IllegalArgumentException();
        }
    }
}

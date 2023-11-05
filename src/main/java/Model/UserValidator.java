package Model;

public class UserValidator {

    private static final int MONEY_MAX_LENGTH = 10;

    void validateMoneyLength(String money) {
        if (money.length() > MONEY_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}

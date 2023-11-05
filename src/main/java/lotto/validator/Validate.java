package lotto.validator;

public class Validate {

    public static void moneyValidate(final String money) {
        if (money != "^[0-9]*$") {
            throw new IllegalArgumentException();
        }
    }
}

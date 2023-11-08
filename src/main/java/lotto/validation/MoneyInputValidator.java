package lotto.validation;

public class MoneyInputValidator {

    public boolean isDividedThousand(int money) {
        return (money % 1000 == 0);
    }
}

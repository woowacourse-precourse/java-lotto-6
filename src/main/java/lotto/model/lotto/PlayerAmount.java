package lotto.model.lotto;

import static lotto.utils.Constant.MIN_MONEY;
import static lotto.utils.Validator.validateDivisibleAmount;
import static lotto.utils.Validator.validateMinimumAmount;

public class PlayerAmount {
    private final int amount;

    private PlayerAmount(int amount) {
        this.amount = amount;
    }

    public static PlayerAmount getInstance(int money) {
        validate(money);
        return new PlayerAmount(calculateMoneyToAmount(money));
    }

    private static void validate(int money) {
        validateMinimumAmount(money);
        validateDivisibleAmount(money);
    }

    private static int calculateMoneyToAmount(int money) {
        return money / MIN_MONEY.getValue();
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.valueOf(amount);
    }
}

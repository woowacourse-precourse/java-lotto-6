package lotto.domain;

import lotto.util.InputUtil;
import lotto.validation.DomainValidate;

public class UserMoney {
    private final int money;

    private UserMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public static UserMoney createMoney(int money) {
        try {
            validate(money);
            return new UserMoney(money);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createMoney(InputUtil.enterMoneyWhileVerifying());
        }
    }
    private static void validate(int money) {
        DomainValidate.validateNegativeMoney(money);
    }
}

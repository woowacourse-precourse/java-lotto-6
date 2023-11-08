package lotto.domain;

import lotto.constant.Constant;
import lotto.util.Convertor;
import lotto.util.Validator;

public class Money {

    private final int money;

    public Money(String inputMoney) {
        int money = Convertor.convertToInt(inputMoney);
        Validator.validateMoney(money);
        this.money = money;
    }

    public int calculateTicket() {
        return money / Constant.MONEY_UNIT;
    }

    public double calculateRevenue(double rewards) {
        return (rewards / money) * 100;
    }

}

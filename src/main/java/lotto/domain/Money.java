package lotto.domain;

import lotto.util.Convertor;
import lotto.util.Validator;

public class Money {

    private final int money;
    private final int UNIT = 1000;

    public Money(String inputMoney) {
        int money = Convertor.getInstance().convertToInt(inputMoney);
        Validator.getInstance().validateMoney(money);
        this.money = money;
    }

    public int calculateTicket() {
        return money / UNIT;
    }

    public double calculateRevenue(double rewards) {
        return (rewards / money) * 100;
    }

}

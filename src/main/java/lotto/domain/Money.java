package lotto.domain;

import static lotto.validator.MoneyValidator.validateMoney;

public class Money {
    private static final int LOTTO_PRICE = 1000;

    private final int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public int getNumberOfLottoTickets() {
        return money / LOTTO_PRICE;
    }
}

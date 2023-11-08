package lotto.model;

import lotto.constant.LottoConstant;

public class Money {
    private int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        if (money % LottoConstant.LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException();
        }
        if (money < LottoConstant.LOTTO_PRICE.getValue()) {
            System.out.println(money + " " + LottoConstant.LOTTO_PRICE.getValue());
            throw new IllegalArgumentException();
        }
    }

    public int getMoney() {
        return money;
    }
}

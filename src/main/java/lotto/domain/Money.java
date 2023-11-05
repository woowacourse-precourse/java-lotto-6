package lotto.domain;

import lotto.constants.LottoStatus;

public class Money {
    private final int money;
    private final int howManyLotto;

    public Money(int money) {
        isMoreThanPrice(money);
        isDividedByPrice(money);
        this.money = money;
        this.howManyLotto = money / LottoStatus.PRICE;
    }

    private void isMoreThanPrice(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException();
        }
    }

    private void isDividedByPrice(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    public int getMoney() {
        return money;
    }

    public int getHowManyLotto() {
        return howManyLotto;
    }

}

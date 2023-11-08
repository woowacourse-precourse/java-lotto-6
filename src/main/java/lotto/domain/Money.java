package lotto.domain;

import lotto.constants.messages.Error;
import lotto.constants.LottoStatus;

public class Money {
    private final long money;
    private final long howManyLotto;

    public Money(long money) {
        isMoreThanPrice(money);
        isDividedByPrice(money);
        this.money = money;
        this.howManyLotto = money / LottoStatus.PRICE;
    }

    private void isMoreThanPrice(long money) {
        if (money < LottoStatus.PRICE) {
            throw new IllegalArgumentException(Error.NOT_ENOUGH_MONEY);
        }
    }

    private void isDividedByPrice(long money) {
        if (money % LottoStatus.PRICE != 0) {
            throw new IllegalArgumentException(Error.NO_CHANGE);
        }
    }

    public long getMoney() {
        return money;
    }

    public long getHowManyLotto() {
        return howManyLotto;
    }
}

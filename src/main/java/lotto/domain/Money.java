package lotto.domain;

import lotto.constants.GameInfo;
import lotto.validator.impl.MoneyValidator;

public class Money {
    private int money;
    private int lottoCount;

    public Money(String money) {
        validate(money);
        this.money = Integer.parseInt(money);
        this.lottoCount = buyLotto();
    }

    void validate(String money) {
        new MoneyValidator().validate(money);
    }

    public int getMoney() {
        return money;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public int buyLotto() {
        return this.money / GameInfo.LOTTO_PRICE.getNumber();
    }
}

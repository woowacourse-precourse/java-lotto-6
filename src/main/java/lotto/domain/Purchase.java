package lotto.domain;

import lotto.constants.GameInfo;
import lotto.validator.impl.MoneyValidator;

public class Purchase {
    private final int money;
    private final int lottoCount;

    public Purchase(String money, MoneyValidator moneyValidator) {
        validate(money, moneyValidator);
        this.money = Integer.parseInt(money);
        this.lottoCount = buyLotto();
    }

    void validate(String money, MoneyValidator moneyValidator) {
        moneyValidator.validate(money);
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

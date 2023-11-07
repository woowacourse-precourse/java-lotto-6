package lotto.domain;

import lotto.constant.ErrorMessage;

public class PurchaseMoney {

    private final Integer money;
    private final Integer count;

    public PurchaseMoney(Integer money) {
        validate(money);
        this.money = money;
        this.count = money / 1000;
    }

    private void validate(Integer money) {
        if(money % 1000 != 0 )
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_PRICE.toMessage());
    }

    public Integer getCount() {
        return this.count;
    }

    public Integer getMoney() {
        return this.money;
    }
}

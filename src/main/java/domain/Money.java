package domain;

import static constant.ConstantNumber.LOTTO_PRICE;

import validator.MoneyValidator;

public class Money {
    private final long money;
    private final long lottoCount;

    public Money(String money) {
        validate(money);
        this.money = Long.parseLong(money);
        this.lottoCount = this.money / LOTTO_PRICE.getNumber();
    }

    private void validate(String money) {
        MoneyValidator.isNumeric(money);
        MoneyValidator.isZero(money);
        MoneyValidator.isThousandUnit(money);
    }

    public long getMoney() {
        return money;
    }

    public long getLottoCount() {
        return lottoCount;
    }
}

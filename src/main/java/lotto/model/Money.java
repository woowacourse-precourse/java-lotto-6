package lotto.model;

import lotto.model.constant.LottoNumber;

public class Money {
    private static final String MONEY_MUST_MULTIPLE_OF_THOUSAND = "[ERROR] 금액은 1,000원 단위로 나누어 떨어져야 합니다.";
    private final int money;

    public Money(Integer money) {
        validate(money);
        this.money = money;
    }

    public void validate(Integer money) {
        if (money % LottoNumber.DEFAULT_UNIT != 0) {
            throw new IllegalArgumentException(MONEY_MUST_MULTIPLE_OF_THOUSAND);
        }
    }

    public int getMoney() {
        return money;
    }
}

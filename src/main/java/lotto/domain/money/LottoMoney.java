package lotto.domain.money;

import lotto.validator.domain.LottoMoneyValidator;

public record LottoMoney(int value) {

    public static LottoMoney from(final int value) {
        LottoMoneyValidator.validate(value);
        return new LottoMoney(value);
    }

    public int createBuyingCount() {
        return value / LottoMoneyCondition.MONEY_UNIT.value();
    }
}

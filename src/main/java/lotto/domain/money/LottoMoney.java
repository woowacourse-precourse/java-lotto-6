package lotto.domain.money;

import lotto.validator.domain.exception.DomainExceptionMessage;

public record LottoMoney(int value) {

    public static LottoMoney from(final int value) {
        validate(value);
        return new LottoMoney(value);
    }

    public static void validate(final int money) {
        if (LottoMoneyCondition.isInvalidValue(money)) {
            throw DomainExceptionMessage.INVALID_MONEY_VALUE.create();
        }
    }

    public int calculateBuyingCount() {
        return value / LottoMoneyCondition.MONEY_UNIT.value();
    }
}

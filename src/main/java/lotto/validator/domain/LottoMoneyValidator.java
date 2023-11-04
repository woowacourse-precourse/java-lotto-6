package lotto.validator.domain;

import lotto.domain.money.LottoMoneyCondition;
import lotto.validator.domain.exception.DomainExceptionMessage;

public class LottoMoneyValidator {

    public static void validate(final int money) {
        if (LottoMoneyCondition.isInvalidValue(money)) {
            throw DomainExceptionMessage.INVALID_MONEY_VALUE.create();
        }
    }
}

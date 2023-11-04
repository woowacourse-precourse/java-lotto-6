package lotto.validator.domain;

import lotto.domain.money.LottoMoneyCondition;
import lotto.validator.domain.exception.DomainExceptionMessage;
import lotto.validator.domain.exception.DomainIllegalArgumentException;

public class LottoMoneyValidator {

    public static void validate(final int money) {
        if (LottoMoneyCondition.isInvalidValue(money)) {
            throw new DomainIllegalArgumentException(DomainExceptionMessage.INVALID_MONEY_VALUE);
        }
    }
}

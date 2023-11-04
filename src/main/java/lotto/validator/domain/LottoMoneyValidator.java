package lotto.validator.domain;

import lotto.domain.money.LottoMoneyCondition;

public class LottoMoneyValidator {

    private static final String INVALID_MONEY_VALUE = "[ERROR] 금액은 천원 이상 만원 이하의 1000원 단위의 금액이어야 합니다.";

    public static void validate(final int value) {
        if (LottoMoneyCondition.isInvalidValue(value)) {
            throw new IllegalArgumentException(INVALID_MONEY_VALUE);
        }
    }
}

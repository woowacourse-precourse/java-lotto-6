package lotto.domain;

import static lotto.domain.exception.DomainExceptionCode.BONUS_NUMBER_MUST_BE_BETWEEN_SIZE;

public record BonusNumber(int value) {

    public BonusNumber {
        BONUS_NUMBER_MUST_BE_BETWEEN_SIZE.dynamicInvokeBy(() -> value < 1);
        BONUS_NUMBER_MUST_BE_BETWEEN_SIZE.dynamicInvokeBy(() -> value > 45);
    }

}

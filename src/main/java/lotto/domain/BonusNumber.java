package lotto.domain;

import lotto.domain.exception.DomainExceptionCode;

public record BonusNumber(int value) {

    public BonusNumber {
        DomainExceptionCode.BONUS_NUMBER_MUST_BE_BETWEEN_SIZE.dynamicInvokeBy(() -> value < 1 || value > 45);
    }

}

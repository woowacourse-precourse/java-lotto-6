package lotto.domain;

import static lotto.domain.constant.LottoNumberConstant.LOTTO_NUMBER_MAX_SIZE;
import static lotto.domain.constant.LottoNumberConstant.LOTTO_NUMBER_MIN_SIZE;
import static lotto.domain.exception.DomainExceptionCode.BONUS_NUMBER_MUST_BE_BETWEEN_SIZE;

public record BonusNumber(int value) {

    public BonusNumber {
        BONUS_NUMBER_MUST_BE_BETWEEN_SIZE.dynamicInvokeBy(() -> LOTTO_NUMBER_MIN_SIZE.isGreaterThan(value));
        BONUS_NUMBER_MUST_BE_BETWEEN_SIZE.dynamicInvokeBy(() -> LOTTO_NUMBER_MAX_SIZE.isLessThan(value));
    }

}

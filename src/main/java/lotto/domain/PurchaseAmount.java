package lotto.domain;

import lotto.constant.LottoConstant;
import lotto.constant.message.ExceptionMessage;

public class PurchaseAmount {

    private final Integer value;

    public PurchaseAmount(final Integer value) {
        validateOverOneHundredThousand(value);
        validateDivisibilityByThousand(value);
        this.value = value;
    }

    private void validateDivisibilityByThousand(final Integer value) {
        if (isDivideByThousand(value)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DIVIDE_THOUSAND.toMessage());
        }
    }

    private boolean isDivideByThousand(final Integer value) {
        return value % LottoConstant.THOUSAND != LottoConstant.ZERO;
    }

    private void validateOverOneHundredThousand(final Integer value) {
        if (value > LottoConstant.MAX_LOTTO_PRICE) {
            throw new IllegalArgumentException(ExceptionMessage.OVER_ONE_HUNDRED_THOUSAND.toMessage());
        }
    }

    public Integer getDivideByThousand() {
        return value / LottoConstant.THOUSAND;
    }

    public Integer toValue() {
        return value;
    }
}

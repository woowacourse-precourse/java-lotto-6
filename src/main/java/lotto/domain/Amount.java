package lotto.domain;

import lotto.constant.ExceptionMessage;

public class Amount {

    private static final int THOUSAND = 1000;
    private static final int ZERO = 0;
    private final Integer value;

    public Amount(final Integer value) {
        validateDivisibilityByThousand(value);
        this.value = value;
    }

    private void validateDivisibilityByThousand(final Integer value) {
        if (isDivideByThousand(value)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DIVIDE_THOUSAND.toMessage());
        }
    }

    private boolean isDivideByThousand(final Integer value) {
        return value % THOUSAND != ZERO;
    }

    public Integer divideByThousand() {
        return value / THOUSAND;
    }

    public Integer toValue() {
        return value;
    }
}

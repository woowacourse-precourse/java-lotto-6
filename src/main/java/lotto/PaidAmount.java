package lotto;

import lotto.constants.LottoConfig;

public class PaidAmount {

    private final Integer paidAmount;

    public PaidAmount(final Integer paidAmount) {
        validate(paidAmount);
        this.paidAmount = paidAmount;
    }

    private void validate(Integer paidAmount) {
        if (isZero(paidAmount)) {
            throw new IllegalArgumentException();
        }
        if (isNotDivisibleByPrice(paidAmount)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isZero(Integer paidAmount) {
        return paidAmount == 0;
    }

    private boolean isNotDivisibleByPrice(Integer paidAmount) {
        return paidAmount % LottoConfig.PRICE_PER_TICKET != 0;
    }
}

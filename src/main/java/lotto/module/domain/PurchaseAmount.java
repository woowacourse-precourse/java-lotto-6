package lotto.module.domain;

import lotto.global.exception.LottoException;

public class PurchaseAmount {
    private final int MINIMUM_PURCHASE_AMOUNT_UNIT = 1_000;
    private final int MAXIMUM_PURCHASE_AMOUNT = 1_000_000_000;
    private final int MINIMUM_PURCHASE_AMOUNT = 1_000;
    private final int payment;

    private PurchaseAmount(final int payment) {
        this.payment = payment;
        validatePayment();
    }

    public static PurchaseAmount newInstance(final int payment) {
        return new PurchaseAmount(payment);
    }

    public int getPayment() {
        return payment;
    }

    private void validatePayment() {
        validatePaymentMin();
        validatePaymentMax();
        validatePaymentUnit();
    }

    private void validatePaymentUnit() {
        if (payment % MINIMUM_PURCHASE_AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(LottoException.INVALID_PURCHASE_AMOUNT_UNIT_VALIDATION.getDefaultMessage());
        }
    }

    private void validatePaymentMin() {
        if (payment < MINIMUM_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(LottoException.MINIMUM_PURCHASE_AMOUNT_NOT_MET_VALIDATION.getDefaultMessage());
        }
    }

    private void validatePaymentMax() {
        if (payment > MAXIMUM_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(LottoException.MAXIMUM_PURCHASE_AMOUNT_NOT_MET_VALIDATION.getDefaultMessage());
        }
    }

}

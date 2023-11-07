package lotto.exception;

import lotto.constant.Error;

public class PurchaseException {

    private static PurchaseException purchaseException = new PurchaseException();

    private PurchaseException() {
    }

    public static PurchaseException getPurchaseException() {
        return purchaseException;
    }

    public void minimumPay() {
        throw new IllegalArgumentException(Error.MINIMUM_PAYMENT.getMessage());
    }

    public void payThousand() {
        throw new IllegalArgumentException(Error.ONLY_VALUE_THOUSAND.getMessage());
    }
}

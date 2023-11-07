package lotto.exception;

import lotto.constant.Error;

public class PurchaseException extends IllegalArgumentException {

    public PurchaseException(Error error) {
        super(error.getMessage());
        System.out.println(error.getMessage());
    }

}

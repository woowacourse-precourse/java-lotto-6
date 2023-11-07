package lotto.exception.purchaseamount;

import lotto.exception.CustomException;

public class PurchaseAmountLimitException extends CustomException {

    private static final String message = "[ERROR] : 로또 구입 금액은 1000 이상의 정수입니다.";

    public PurchaseAmountLimitException() {
        super(message);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
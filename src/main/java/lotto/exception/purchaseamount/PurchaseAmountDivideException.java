package lotto.exception.purchaseamount;

import lotto.exception.CustomException;

public class PurchaseAmountDivideException extends CustomException {

    private static final String message = "[ERROR] : 로또 구입 금액은 1000으로 나누어 떨어져야 합니다.";

    public PurchaseAmountDivideException() {
        super(message);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
package exception.lottoException;

import constants.Constants;

public class NotDivisibleException extends IllegalArgumentException {

    private static final String message = String.format(
            "로또 한장의 가격으로 나누어떨어지지 않는 금액은 받을 수 없습니다. (한장 가격 : %d)",
            Constants.LOTTO_PRICE);

    public NotDivisibleException() {
        super(message);
    }
}
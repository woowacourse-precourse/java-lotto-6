package lotto.controller.exception;

public final class InvalidLottoPriceUnitException extends IllegalArgumentException {
    public static final String INVALID_LOTTO_PRICE_UNIT_EXCEPTION_MESSAGE = "구입 금액은 반드시 1,000원 단위로 나누어 떨어져야 합니다.";

    public InvalidLottoPriceUnitException() {
        super(INVALID_LOTTO_PRICE_UNIT_EXCEPTION_MESSAGE);
    }
}

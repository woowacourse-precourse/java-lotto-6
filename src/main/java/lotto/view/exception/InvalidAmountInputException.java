package lotto.view.exception;

/**
 * 구입금액 입력 시 숫자가 아닐 경우 발생하는 예외입니다.
 */
public final class InvalidAmountInputException extends IllegalArgumentException {
    public static final String INVALID_AMOUNT_INPUT_EXCEPTION = "구입 금액은 반드시 숫자를 입력해주세요.";

    public InvalidAmountInputException() {
        super(INVALID_AMOUNT_INPUT_EXCEPTION);
    }
}

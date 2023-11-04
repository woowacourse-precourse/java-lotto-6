package lotto.exception;

/**
 * 숫자가 아닌 경우 발생하는 예외
 */
public class InvalidAmountFormatException extends BaseIllegalArgumentException {
    private static final String MESSAGE = "구입 금액은 원 단위로 입력하십시오.";

    public InvalidAmountFormatException() {
        super(MESSAGE);
    }
}

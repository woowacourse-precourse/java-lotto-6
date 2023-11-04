package lotto.exception;

/**
 * 입력한 값이 0 이하일 경우 발생하는 예외
 */
public class NonPositiveAmountException extends BaseIllegalArgumentException {
    private static final String MESSAGE = "0원 이하의 금액은 입력할 수 없습니다.";

    public NonPositiveAmountException() {
        super(MESSAGE);
    }
}

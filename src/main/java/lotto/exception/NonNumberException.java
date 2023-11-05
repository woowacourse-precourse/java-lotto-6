package lotto.exception;

public class NonNumberException extends BaseIllegalArgumentException {

    private static final String MESSAGE = "입력한 값이 숫자가 아닙니다.";

    public NonNumberException() {
        super(MESSAGE);
    }
}

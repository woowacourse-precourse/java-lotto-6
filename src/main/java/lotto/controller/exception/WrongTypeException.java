package lotto.controller.exception;

public class WrongTypeException extends IllegalArgumentException {
    private static final String MESSAGE = "[ERROR] 잘못 입력하였습니다.";

    public WrongTypeException() {
        super(MESSAGE);
    }
}

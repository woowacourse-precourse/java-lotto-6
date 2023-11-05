package lotto.exception;

public class InvalidBallException extends IllegalArgumentException {

    private static final String INVALID_BALL = "[ERROR] 번호는 1 이상 45 이하여야 합니다.";

    public InvalidBallException() {
        super(INVALID_BALL);
    }
}

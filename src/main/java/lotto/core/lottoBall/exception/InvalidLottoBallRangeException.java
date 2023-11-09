package lotto.core.lottoBall.exception;

public class InvalidLottoBallRangeException extends IllegalArgumentException {

    private static final String INVALID_LOTTO_BALL_RANGE_MESSAGE = "[ERROR] 로또 번호는 1~45 사이의 숫자여야 합니다.";

    public InvalidLottoBallRangeException() {
        super(INVALID_LOTTO_BALL_RANGE_MESSAGE);
    }
}

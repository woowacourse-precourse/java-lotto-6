package lotto.core.lottoBall.exception;

public class InvalidLottoBallSizeException extends IllegalArgumentException {

    private static final String INVALID_LOTTO_BALL_SIZE_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";

    public InvalidLottoBallSizeException() {
        super(INVALID_LOTTO_BALL_SIZE_MESSAGE);
    }
}

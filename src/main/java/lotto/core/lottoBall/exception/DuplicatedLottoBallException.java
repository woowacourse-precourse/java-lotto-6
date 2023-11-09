package lotto.core.lottoBall.exception;

public class DuplicatedLottoBallException extends IllegalArgumentException {

    private static final String DUPLICATED_LOTTO_BALL_MESSAGE = "[ERROR] 로또 공은 중복될 수 없습니다.";

    public DuplicatedLottoBallException() {
        super(DUPLICATED_LOTTO_BALL_MESSAGE);
    }
}

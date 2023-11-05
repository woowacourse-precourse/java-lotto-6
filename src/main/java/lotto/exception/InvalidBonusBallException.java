package lotto.exception;

public class InvalidBonusBallException extends IllegalArgumentException {

    private static final String INVALID_BONUS_BALL = "[ERROR] 보너스 번호는 당첨 번호에 포함되어 있으면 안 됩니다.";

    public InvalidBonusBallException() {
        super(INVALID_BONUS_BALL);
    }
}

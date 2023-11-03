package lotto.exception;

public class InvalidBonusNumberException extends IllegalArgumentException {

    public static final String INVALID_BONUS_NUMBER = "보너스 번호는 당첨 번호에 포함되어 있으면 안 됩니다.";

    public InvalidBonusNumberException() {
        super(INVALID_BONUS_NUMBER);
    }
}

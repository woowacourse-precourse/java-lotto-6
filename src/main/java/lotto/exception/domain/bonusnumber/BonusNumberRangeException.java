package lotto.exception.domain.bonusnumber;

public class BonusNumberRangeException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 보너스 숫자는 1~45사이의 숫자여야 합니다.";

    public BonusNumberRangeException() {
        super(ERROR_MESSAGE);
    }
}

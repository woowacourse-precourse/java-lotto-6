package lotto.exception.lotto.bonus;

public class BonusNumberFormatException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 숫자가 아닌 값이 입력되었습니다.";

    public BonusNumberFormatException() {
        super(ERROR_MESSAGE);
    }
}

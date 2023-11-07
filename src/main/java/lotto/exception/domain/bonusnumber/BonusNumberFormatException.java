package lotto.exception.domain.bonusnumber;

public class BonusNumberFormatException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 보너스 숫자는 숫자만 입력해야 합니다.";

    public BonusNumberFormatException() {
        super(ERROR_MESSAGE);
    }
}

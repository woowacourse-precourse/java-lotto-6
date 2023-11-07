package lotto.exception.domain.bonusnumber;

public class BonusNumberDuplicateException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 보너스 숫자는 당첨 번호와 중복되면 안됩니다.";

    public BonusNumberDuplicateException() {
        super(ERROR_MESSAGE);
    }
}

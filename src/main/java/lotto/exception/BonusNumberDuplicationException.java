package lotto.exception;

public class BonusNumberDuplicationException extends IllegalArgumentException {

    public static final String ERROR_MESSAGE = "당첨 번호 중에 보너스 번호와 중복되는 숫자가 있어선 안됩니다.";

    public BonusNumberDuplicationException() {
        super(ERROR_MESSAGE);
    }
}

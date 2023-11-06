package lotto.exception;

public class BonusNumDuplicateException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "당첨 번호에 보너스 번호가 포함되어 있습니다.";

    public BonusNumDuplicateException(){
        super(ERROR_MESSAGE);
    }
}

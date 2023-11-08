package lotto.exception;

public class BonusNumberException extends Throwable {
    private static final String ERROR_MESSAGE = "[ERROR] 이미 존재하는 번호입니다.";

    public BonusNumberException() {
        super(ERROR_MESSAGE);
    }
}

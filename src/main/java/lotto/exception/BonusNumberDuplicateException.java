package lotto.exception;

public class BonusNumberDuplicateException extends RuntimeException {
    private static final String MESSAGE = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";

    public BonusNumberDuplicateException() {
        super(MESSAGE);
    }
}

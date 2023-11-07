package lotto.exception;

public class DuplicateWinningNumberException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 번호가 중복되는 당첨 번호가 존재합니다.";

    public DuplicateWinningNumberException() {
        super(ERROR_MESSAGE);
    }
}

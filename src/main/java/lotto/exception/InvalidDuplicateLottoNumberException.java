package lotto.exception;

public class InvalidDuplicateLottoNumberException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 로또 숫자가 중복되었습니다.";

    public InvalidDuplicateLottoNumberException() {
        super(ERROR_MESSAGE);
    }
}

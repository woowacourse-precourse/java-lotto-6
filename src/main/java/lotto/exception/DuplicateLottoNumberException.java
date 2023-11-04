package lotto.exception;

public class DuplicateLottoNumberException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 로또 번호가 중복 됩니다.";

    public DuplicateLottoNumberException() {
        super(ERROR_MESSAGE);
    }
}

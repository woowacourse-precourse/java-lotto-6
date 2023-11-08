package lotto.exception;

public class DuplicateLottoNumberException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 중복된 로또 번호가 존재합니다.";

    public DuplicateLottoNumberException() {
        super(ERROR_MESSAGE);
    }
}

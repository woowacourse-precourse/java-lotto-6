package lotto.exception;

public class InvalidSizeLottoNumberException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";

    public InvalidSizeLottoNumberException() {
        super(ERROR_MESSAGE);
    }
}

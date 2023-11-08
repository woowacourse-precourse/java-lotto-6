package exception;

public class DuplicateLottoNumberException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE_START = "[ERROR] ";
    private static final String ERROR_MESSAGE = ERROR_MESSAGE_START + "로또 번호는 중복될 수 없습니다.";

    public DuplicateLottoNumberException() {
        super(ERROR_MESSAGE);
    }
}

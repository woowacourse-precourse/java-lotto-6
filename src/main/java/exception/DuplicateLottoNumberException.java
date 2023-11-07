package exception;

public class DuplicateLottoNumberException extends IllegalArgumentException {

    private static final String message = "로또 번호는 중복된 숫자를 포함할 수 없습니다.";

    public DuplicateLottoNumberException() {
        super(message);
    }
}
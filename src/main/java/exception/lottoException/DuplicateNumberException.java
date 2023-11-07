package exception.lottoException;

public class DuplicateNumberException extends IllegalArgumentException {

    private static final String message = "로또 번호는 중복된 숫자를 포함할 수 없습니다.";

    public DuplicateNumberException() {
        super(message);
    }
}
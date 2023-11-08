package lotto.exception;

public class DuplicateNumberException extends CustomException {
    public DuplicateNumberException() {
        super("중복된 값이 존재합니다.");
    }
}

package lotto.exception.lotto;

public class DuplicateNumberException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 로또 번호는 중복될 수 없습니다.";

    public DuplicateNumberException() {
        super(ERROR_MESSAGE);
    }
}

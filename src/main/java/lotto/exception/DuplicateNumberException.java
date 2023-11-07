package lotto.exception;

public class DuplicateNumberException extends LottoGameException {

    private static final String MESSAGE = "숫자는 중복될 수 없습니다." ;

    public DuplicateNumberException() {
        super(MESSAGE);
    }
}

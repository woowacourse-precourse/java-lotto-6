package lotto.exception;

public class NotLottoSizeException extends IllegalArgumentException {
    private static final String MESSAGE = "로또 번호는 6개여야 합니다.";

    public NotLottoSizeException() {
        super(MESSAGE);
    }
}

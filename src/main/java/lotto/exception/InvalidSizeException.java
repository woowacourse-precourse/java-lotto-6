package lotto.exception;

public class InvalidSizeException extends LottoGameException {

    private static final String MESSAGE = "로또 번호 개수는 6개여야 합니다.";

    public InvalidSizeException() {
        super(MESSAGE);
    }
}

package lotto.exception;

public class InvalidLottoSizeException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 로또 번호의 개수가 6개가 아닙니다.";

    public InvalidLottoSizeException() {
        super(ERROR_MESSAGE);
    }
}

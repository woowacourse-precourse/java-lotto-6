package lotto.view.exception;

public class InvalidLottoSizeException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "[ERROR] 로또 번호 개수가 6개가 아님";

    public InvalidLottoSizeException() {
        super(ERROR_MESSAGE);
    }
}

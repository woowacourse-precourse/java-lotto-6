package exception;

public class InvalidLottoSizeException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 로또 번호의 갯수(6개)가 충족되지 않았습니다!";

    public InvalidLottoSizeException() {
        super(ERROR_MESSAGE);
    }
}

package exception;

public class InvalidLottoNumberRangeException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 범위 (1 ~ 45) 밖의 숫자가 입력되었습니다!";

    public InvalidLottoNumberRangeException() {
        super(ERROR_MESSAGE);
    }
}

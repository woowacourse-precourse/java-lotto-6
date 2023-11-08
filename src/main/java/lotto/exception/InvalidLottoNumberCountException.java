package lotto.exception;

public class InvalidLottoNumberCountException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 로또 숫자 갯수가 맞지 않습니다.";

    public InvalidLottoNumberCountException() {
        super(ERROR_MESSAGE);
    }
}

package lotto.exception;

public class InvalidSizeOfLottoException extends IllegalArgumentException{

    private static final String ERROR_MESSAGE = "[ERROR] 로또 번호의 사이즈가 맞지 않습니다.";

    public InvalidSizeOfLottoException() {
        super(ERROR_MESSAGE);
    }
}

package lotto.exception;

public class InvalidLottoNumberSizeException extends IllegalArgumentException {

    private static final String INVALID_LOTTO_NUMBER_SIZE_MESSAGE = "[ERROR] 올바른 로또 숫자 개수가 아닙니다.";

    public InvalidLottoNumberSizeException() {
        super(INVALID_LOTTO_NUMBER_SIZE_MESSAGE);
    }
}

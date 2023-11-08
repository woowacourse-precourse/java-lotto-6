package lotto.exception;

public class InvalidSizeOfLottoNumbersException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "로또 번호 개수는 6개를 입력하셔야 합니다.";

    public InvalidSizeOfLottoNumbersException() {
        super(ERROR_MESSAGE);
    }
}

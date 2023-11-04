package lotto.exception;

public class InvalidWinningLottoFormatException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 당첨 번호의 입력 형식이 맞지 않습니다.";

    public InvalidWinningLottoFormatException() {
        super(ERROR_MESSAGE);
    }
}

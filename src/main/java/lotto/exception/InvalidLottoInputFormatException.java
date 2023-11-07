package lotto.exception;

public class InvalidLottoInputFormatException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 당첨 번호 입력 형식에 적절하지 않은 입력입니다.";

    public InvalidLottoInputFormatException() {
        super(ERROR_MESSAGE);
    }
}

package lotto.exception;

public class InvalidWinningNumbersException extends IllegalArgumentException{
    private static final String ERROR_MESSAGE = "[ERROR] 당첨 번호의 형식이 잘못되었습니다.";
    public InvalidWinningNumbersException() {
        super(ERROR_MESSAGE);
    }
}

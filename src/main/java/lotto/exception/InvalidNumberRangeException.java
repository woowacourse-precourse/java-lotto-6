package lotto.exception;

public class InvalidNumberRangeException extends IllegalArgumentException{
    private static final String ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public InvalidNumberRangeException() {
        super(ERROR_MESSAGE);
    }
}

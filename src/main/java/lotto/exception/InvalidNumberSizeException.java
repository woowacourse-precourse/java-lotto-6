package lotto.exception;

public class InvalidNumberSizeException extends IllegalArgumentException{
    private static final String MESSAGE = "[ERROR] 로또 숫자는 6개입니다!";
    public InvalidNumberSizeException() {
        super(MESSAGE);
    }
}

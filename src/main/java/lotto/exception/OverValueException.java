package lotto.exception;

public class OverValueException extends IllegalArgumentException{
    private static final String MESSAGE = "[ERROR] 로또 번호의 범위는 45입니다!";
    public OverValueException() {
        super(MESSAGE);
    }
}

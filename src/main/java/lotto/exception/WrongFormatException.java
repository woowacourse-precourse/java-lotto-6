package lotto.exception;

public class WrongFormatException extends IllegalArgumentException{
    private static final String ERROR_MESSAGE = "[ERROR] 입력 형식이 올바르지 않습니다.";

    public WrongFormatException() {
        super(ERROR_MESSAGE);
        System.out.println(ERROR_MESSAGE);
    }
}

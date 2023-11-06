package lotto.exception;

public class InvalidRangeException extends IllegalArgumentException {

    private static final String ERR_MSG = "[ERROR] 1부터 45까지의 숫자만 입력 가능합니다.";

    public InvalidRangeException() {
        super(ERR_MSG);
    }
}

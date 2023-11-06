package lotto.exception;

public class InvalidSizeException extends IllegalArgumentException {

    private static final String ERR_MSG = "[ERROR] 번호는 여섯 개만 입력 가능합니다.";

    public InvalidSizeException() {
        super(ERR_MSG);
    }
}

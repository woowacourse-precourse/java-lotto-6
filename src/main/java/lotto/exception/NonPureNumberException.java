package lotto.exception;

public class NonPureNumberException extends IllegalArgumentException {

    private static final String ERR_MSG = "[ERROR] 숫자만 입력 가능합니다.";

    public NonPureNumberException() {
        super(ERR_MSG);
    }
}

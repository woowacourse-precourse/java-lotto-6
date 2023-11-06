package lotto.exception;

public class DuplicatedNumberException extends IllegalArgumentException {

    private static final String ERR_MSG = "[ERROR] 숫자의 중복은 허용하지 않습니다.";

    public DuplicatedNumberException() {
        super(ERR_MSG);
    }
}

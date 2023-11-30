package lotto.exception;

public class MissingNumberException extends IllegalArgumentException {
    public MissingNumberException() {
        super("[ERROR] 입력 값이 공백입니다.\n");
    }
}

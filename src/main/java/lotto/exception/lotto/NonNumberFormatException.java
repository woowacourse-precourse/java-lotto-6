package lotto.exception.lotto;

public class NonNumberFormatException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 로또 번호는 숫자값만 입력할 수 있습니다.";

    public NonNumberFormatException() {
        super(ERROR_MESSAGE);
    }
}

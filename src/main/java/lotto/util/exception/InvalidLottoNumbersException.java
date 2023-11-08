package lotto.util.exception;

public class InvalidLottoNumbersException extends IllegalArgumentException {
    private static final String message = "로또 번호는 정수여야 합니다. 입력값: ";

    public InvalidLottoNumbersException(String input, Exception e) {
        super(message + input, e);
    }
}

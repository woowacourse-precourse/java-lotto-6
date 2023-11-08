package lotto.exception;

public class InputMoneyNotDigitException extends IllegalArgumentException{
    private static final String MESSAGE = "[ERROR] 금액은 숫자만 입력 가능합니다.";
    public InputMoneyNotDigitException() {
        super(MESSAGE);
    }
}

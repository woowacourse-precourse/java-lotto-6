package lotto.exception;

public class InputMoneyOverflowException extends IllegalArgumentException{
    private static final String MESSAGE = "[ERROR] 입력한 금액이 유효한 숫자 범위를 벗어났습니다.";
    public InputMoneyOverflowException() {
        super(MESSAGE);
    }
}

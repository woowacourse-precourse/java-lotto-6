package lotto.execption;

public class InputMoneyParseIntException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 숫자가 아닌 값을 입력하였습니다.";

    public InputMoneyParseIntException() {
        super(ERROR_MESSAGE);
    }
}

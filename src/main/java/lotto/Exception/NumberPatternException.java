package lotto.Exception;

public class NumberPatternException extends IllegalArgumentException{
    private static final String ERROR_MESSAGE = "[ERROR] 숫자가 아닌 다른 입력값이 들어왔습니다.";

    public NumberPatternException() {
        super(ERROR_MESSAGE);
    }
}

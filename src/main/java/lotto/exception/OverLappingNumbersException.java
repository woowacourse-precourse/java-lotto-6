package lotto.exception;

public class OverLappingNumbersException extends IllegalArgumentException{
    private static final String ERROR_MESSAGE = "[ERROR] 중복된 숫자가 나왔습니다.";

    public OverLappingNumbersException() {
        super(ERROR_MESSAGE);
    }
}

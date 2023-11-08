package lotto.exception;

public class NotNumberInputException extends IllegalArgumentException{
    private static final String ERROR_MESSAGE = "[ERROR] 숫자가 입력되어야 합니다.";

    public NotNumberInputException() {
        super(ERROR_MESSAGE);
    }


}

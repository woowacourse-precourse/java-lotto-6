package lotto.exception;

public class NotNumberInputException extends LottoException{
    private static final String ERROR_MESSAGE = "숫자가 입력되어야 합니다.";

    public NotNumberInputException() {
        super(ERROR_MESSAGE);
    }


}

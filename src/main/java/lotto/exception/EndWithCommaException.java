package lotto.exception;

public class EndWithCommaException extends LottoException{
    private static final String ERROR_MESSAGE = ",가 마지막으로 입력되면 안됩니다.";

    public EndWithCommaException() {
        super(ERROR_MESSAGE);
    }


}

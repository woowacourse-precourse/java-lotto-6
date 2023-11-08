package lotto.global.exception.base;

public class LottoGameException extends IllegalArgumentException{
    private static final String ERROR_MESSAGE_HEADER = "[ERROR] ";

    public LottoGameException(ErrorBase error) {
        super(ERROR_MESSAGE_HEADER + error.getErrorMessage());
    }

}

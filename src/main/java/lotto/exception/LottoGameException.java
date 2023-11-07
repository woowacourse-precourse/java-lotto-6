package lotto.exception;

public class LottoGameException extends IllegalArgumentException {

    private final CustomException customException;

    public LottoGameException(CustomException customException) {
        this.customException = customException;
    }

    @Override
    public String getMessage() {
        return customException.getMessage();
    }
}

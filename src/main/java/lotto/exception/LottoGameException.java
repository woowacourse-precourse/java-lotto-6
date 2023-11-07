package lotto.exception;

public class LottoGameException extends IllegalArgumentException {
    private ExceptionEnum error;

    public LottoGameException(ExceptionEnum e) {
        super(e.getMessage());
        this.error = e;
    }

    public ExceptionEnum getError() {
        return error;
    }
}

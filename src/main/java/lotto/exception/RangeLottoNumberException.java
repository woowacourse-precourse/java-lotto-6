package lotto.exception;

public class RangeLottoNumberException extends IllegalArgumentException{
    private static final String ERROR_MESSAGE = "[ERROR] 로또는 1~45까지의 범위여야 합니다.";

    public RangeLottoNumberException() {
        super(ERROR_MESSAGE);
    }

}

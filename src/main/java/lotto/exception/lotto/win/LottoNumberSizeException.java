package lotto.exception.lotto.win;

public class LottoNumberSizeException extends IllegalArgumentException{
    private static final String ERROR_MESSAGE = "[ERROR] 로또 번호의 개수가 6개가 아닙니다.";

    public LottoNumberSizeException() {
        super(ERROR_MESSAGE);
    }
}

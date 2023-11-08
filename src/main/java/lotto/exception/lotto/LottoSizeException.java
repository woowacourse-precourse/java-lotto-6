package lotto.exception.lotto;

public class LottoSizeException extends IllegalArgumentException {
    private static final String ERROR_MSG = "[ERROR] 로또는 6개 숫자여야 합니다.";

    public LottoSizeException(){
        super(ERROR_MSG);
    }
}

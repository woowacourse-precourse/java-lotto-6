package lotto.exception;

public class LottoSizeException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 로또의 번호가 6개를 넘었습니다.";

    public LottoSizeException(){
        super(ERROR_MESSAGE);
    }
}

package lotto.exception;

public class LottoNumRangeException  extends  IllegalArgumentException{
    private static final String ERROR_MESSAGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    public LottoNumRangeException(){
        super(ERROR_MESSAGE);
    }
}


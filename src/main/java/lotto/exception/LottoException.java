package lotto.exception;

public class LottoException extends IllegalArgumentException{
    private LottoException(LottoErrorMsg errorMessage) {
        super(errorMessage.getMessage());
    }

    public static LottoException triggeredBy(LottoErrorMsg lottoErrorMsg){
        return new LottoException(lottoErrorMsg);
    }
}

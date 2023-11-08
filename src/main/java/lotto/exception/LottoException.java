package lotto.exception;

public class LottoException extends IllegalArgumentException{
    private LottoException(LottoErrorMsg errorMessage) {
        super(errorMessage.getMessage());
    }

    public static LottoException triggeredBy(LottoErrorMsg lottoErrorMsg){
        System.out.println(lottoErrorMsg.getMessage());
        return new LottoException(lottoErrorMsg);
    }
}

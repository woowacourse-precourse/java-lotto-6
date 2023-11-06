package lotto.exception;
import lotto.exception.constant.ErrorMessage;
public class LottoException extends IllegalArgumentException{
    private LottoException(ErrorMessage errorMessage) {
        super(errorMessage.getErrorMessage());
    }
    public static LottoException of(ErrorMessage errorMessage) {
        return new LottoException(errorMessage);
    }
    public static void printErrorMessage(LottoException e) {
        System.out.println(e.getMessage());
    }
}

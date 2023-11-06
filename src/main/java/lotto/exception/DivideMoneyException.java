package lotto.exception;


public class DivideMoneyException extends IllegalArgumentException{
    private static final String ERROR_MESSAGE =
            CommonExceptionMessage.PREFIX_EXCEPTION.getMessage() + "로또 구입 금액은 1000원 단위입니다.";

    public DivideMoneyException(){
        super(ERROR_MESSAGE);
    }
}

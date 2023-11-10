package lotto.exception;

public class LottoMoneyLessException extends IllegalStateException {
    private static final String ERROR_MESSAGE = "[ERROR] 구입 금액이 1,000원 이상부터 가능합니다.";

    public LottoMoneyLessException(){
        super(ERROR_MESSAGE);
    }
}

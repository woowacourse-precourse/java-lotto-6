package lotto.exception;

public class LottoMoneyDivideException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 구입 금액이 1,000원 단위만 가능합니다.";

    public LottoMoneyDivideException(){
        super(ERROR_MESSAGE);
    }
}

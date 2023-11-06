package lotto.exception.money;

public class MoneyDivisionException extends IllegalArgumentException{
    private static final String ERROR_MSG = "[ERROR] 금액은 1000 의 배수여야 합니다.";

    public MoneyDivisionException() {
        super(ERROR_MSG);
    }
}

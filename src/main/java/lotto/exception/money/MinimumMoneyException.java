package lotto.exception.money;

public class MinimumMoneyException extends IllegalArgumentException {
    private static final String MINIMUM_AMOUNT_MSG = "최소 금액은 1,000원 입니다.";

    public MinimumMoneyException() {
        super(MINIMUM_AMOUNT_MSG);
    }
}

package lotto.exception.money;

public class MoneyOutOfRangeException extends IllegalArgumentException {
    private static final String MAX_AMOUNT_MSG = "최대 2,147,483,000원 까지 구매 가능합니다.";

    public MoneyOutOfRangeException() {
        super(MAX_AMOUNT_MSG);
    }
}

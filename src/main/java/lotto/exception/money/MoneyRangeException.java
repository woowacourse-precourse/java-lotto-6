package lotto.exception.money;

public class MoneyRangeException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 로또 구입 금액은 1000원 이상이어야 합니다. : %d";

    public MoneyRangeException(long money) {
        super(String.format(ERROR_MESSAGE, money));
    }
}

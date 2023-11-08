package lotto.exception;

public class ZeroMoneyException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 로또는 0원 이상부터 구매할 수 있습니다.";

    public ZeroMoneyException() {
        super(ERROR_MESSAGE);
    }
}

package lotto.exception;

public class DivideMoneyException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 로또 구입 금액은 1000원으로 나누어 떨어져야 합니다.";

    public DivideMoneyException() {
        super(ERROR_MESSAGE);
    }
}

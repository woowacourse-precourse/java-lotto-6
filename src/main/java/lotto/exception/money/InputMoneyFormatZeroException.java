package lotto.exception.money;

public class InputMoneyFormatZeroException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "로또 구입 금액은 0원 이상 이어야 합니다.";

    public InputMoneyFormatZeroException() {
        super(ERROR_MESSAGE);
    }
}

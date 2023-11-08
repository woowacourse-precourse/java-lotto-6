package lotto.exception;

public class DivideMoneyException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 1,000원 단위의 금액을 입력해야합니다.";

    public DivideMoneyException() {
        super(ERROR_MESSAGE);
    }
}
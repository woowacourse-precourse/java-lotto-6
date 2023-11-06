package lotto.execption;

public class MoneyException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 구입 금액을 잘 못 입력했습니다.";

    public MoneyException() {
        super(ERROR_MESSAGE);
    }
}

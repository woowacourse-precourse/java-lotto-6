package lotto.exception.money;

public class MoneyNumberFormatException extends IllegalArgumentException {
    private static final String ONLY_NUMBER_ALLOWED_MESSAGE = "숫자만 입력해 주세요.";

    public MoneyNumberFormatException() {
        super(ONLY_NUMBER_ALLOWED_MESSAGE);
    }
}

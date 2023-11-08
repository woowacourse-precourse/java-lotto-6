package lotto.exception;

public class NotMultipleOfLottoPriceException extends IllegalArgumentException {
    private static final String MESSAGE = "1,000원 단위의 금액을 입력해 주세요.";

    public NotMultipleOfLottoPriceException() {
        super(MESSAGE);
    }
}

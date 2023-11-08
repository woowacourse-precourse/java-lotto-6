package lotto.exception;

public class DivideByLottoPriceException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "1000원으로 나눠 떨어지는 금액을 입력하시오.";

    public DivideByLottoPriceException() {
        super(ERROR_MESSAGE);
    }
}

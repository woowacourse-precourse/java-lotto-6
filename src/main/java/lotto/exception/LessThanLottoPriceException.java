package lotto.exception;

public class LessThanLottoPriceException extends LottoGameException {

    private static final String MESSAGE = "구입 금액은 로또 가격보다 높아야 합니다.";

    public LessThanLottoPriceException() {
        super(MESSAGE);
    }
}

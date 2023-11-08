package lotto.exception.argument;

public class LottoPriceUnitException extends BaseIllegalArgumentException {
    private static final String MESSAGE = "구입 금액은 1,000원 단위로 입력하십시오.";

    public LottoPriceUnitException() {
        super(MESSAGE);
    }
}

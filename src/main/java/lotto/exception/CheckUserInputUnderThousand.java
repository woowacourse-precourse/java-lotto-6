package lotto.exception;

public class CheckUserInputUnderThousand extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "로또 구입 금액은 1,000원 이상이어야 합니다.";
    public CheckUserInputUnderThousand() {
        super(ERROR_MESSAGE);
    }
}

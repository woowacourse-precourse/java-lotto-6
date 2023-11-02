package lotto.exception;

public class InvalidMoneyRangeException extends IllegalArgumentException {

    private static final String MONEY_RANGE_INPUT_MESSAGE = "[ERROR] 1000원 단위여야 합니다.";

    public InvalidMoneyRangeException() {
        super(MONEY_RANGE_INPUT_MESSAGE);
    }
}

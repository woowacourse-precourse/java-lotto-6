package lotto.validation;

public enum AmountException {
    INVALID_DIGIT_EXCEPTION(new IllegalArgumentException("[ERROR] 구입 금액은 정수만 입력할 수 있습니다.")),
    LEAST_VALUE_EXCEPTION(new IllegalArgumentException("[ERROR] 구입 금액은 최소 1,000원부터입니다.")),
    MOST_VALUE_EXCEPTION(new IllegalArgumentException("[ERROR] 구입 금액은 최대 100,000원까지입니다.")),
    UNIT_EXCEPTION(new IllegalArgumentException("[ERROR] 구입 금액은 1,000의 단위로 입력할 수 있습니다."));

    private final IllegalArgumentException exception;

    AmountException(IllegalArgumentException exception) {
        this.exception = exception;
    }

    public IllegalArgumentException getException() {
        return exception;
    }
}

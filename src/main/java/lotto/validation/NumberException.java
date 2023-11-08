package lotto.validation;

public enum NumberException {
    BLANK_EXCEPTION(new IllegalArgumentException("[ERROR] 번호는 공백일 수 없습니다.")),
    BLANK_CONTAIN_EXCEPTION(new IllegalArgumentException("[ERROR] 번호는 공백이 포함될 수 없습니다.")),
    INVALID_POSITIVE_DIGIT_EXCEPTION(new IllegalArgumentException("[ERROR] 번호는 양의 정수만 입력할 수 있습니다.")),
    OUT_RANGE_RANGE_EXCEPTION(new IllegalArgumentException("[ERROR] 번호는 1이상 45이하의 수만 입력할 수 있습니다.")),
    INVALID_NUMBER_COUNT_EXCEPTION(new IllegalArgumentException("[ERROR] 로또 번호의 개수는 6개여야 합니다.")),
    DUPLICATE_NUMBER_EXCEPTION(new IllegalArgumentException("[ERROR] 중복된 번호는 존재할 수 없습니다."));

    private final IllegalArgumentException exception;

    NumberException(IllegalArgumentException exception) {
        this.exception = exception;
    }

    public IllegalArgumentException getException() {
        return exception;
    }
}

package lotto.constants;

public enum Error {
    DUPLICATION_ERROR("[ERROR] 중복되지 않는 숫자를 입력해 주세요."),
    SIZE_ERROR("[ERROR] 6개의 숫자를 입력해 주세요."),
    NOT_NUMBER_ERROR("[ERROR] 숫자만(양수) 입력해 주세요."),
    REMAINDER_ERROR("[ERROR] 1000단위의 숫자를 입력해 주세요."),
    ZERO_INCLUSION_ERROR("[ERROR] 숫자 앞에 0을 입력하지 마세요."),
    NOT_POSITIVE_NUMBER_ERROR("[ERROR] 양수를 입력해 주세요."),
    RANGE_ERROR("[ERROR] 1~45 범위의 숫자를 입력 하세요."),
    COMMA_ERROR("[ERROR] 마지막에 콤마를 입력하지 마세요.");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

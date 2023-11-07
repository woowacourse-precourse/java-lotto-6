package lotto.validation;

public enum Error {
    INTEGER_ERROR("구입 금액은 정수여야 합니다."),
    POSITIVE_ERROR("구입 금액은 양수여야 합니다."),
    DIVISIBLE_ERROR("구입 금액은 1,000원 단위로 입력해야 합니다."),
    DISTINCT_ERROR("로또 번호는 서로 달라야 합니다."),
    RANGE_ERROR("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    COUNT_ERROR("로또 번호는 6개여야 합니다.");

    private String error;

    Error(String error) {
        this.error = error;
    }

    public String message() {
        return error;
    }
}

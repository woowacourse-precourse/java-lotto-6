package lotto.exception;

public enum ErrorMessage {
    LOTTO_NUMBER_COUNT_ERROR("로또 번호의 개수가 6개가 아닙니다."),
    LOTTO_NUMBER_DUPLICATED_ERROR("로또 번호가 중복됐습니다."),
    LOTTO_NUMBER_RANGE_ERROR("로또 번호의 범위가 1~45에 맞지 않습니다.");

    private final String value;

    ErrorMessage(String value) {
        this.value = value;
    }

    public String getMessage() {
        return value;
    }
}

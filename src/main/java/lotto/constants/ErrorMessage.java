package lotto.constants;

public enum ErrorMessage {
    ERROR_TAG("[ERROR] "),
    NOT_NUMERIC_ERROR("숫자를 입력해 주세요"),
    NOT_THOUSAND_UNIT_ERROR("1000단위로 입력을 해주세요"),
    LOTTO_NUMBER_SIZE_ERROR("로또의 개수가 6이 아닙니다."),
    LOTTO_NUMBER_RANGE_ERROR("로또 숫자 범위가 1 부터 45가 아닙니다."),
    LOTTO_NUMBER_DUPLICATE_ERROR("로또 숫자가 중복되어 있습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_TAG.message + message;
    }

    @Override
    public String toString() {
        return message;
    }
}

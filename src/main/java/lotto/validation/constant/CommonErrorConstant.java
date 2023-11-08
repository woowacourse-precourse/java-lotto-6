package lotto.validation.constant;

public enum CommonErrorConstant {

    NULL_MESSAGE("[ERROR] 값에 null이 들어올 수 없습니다."),
    EMPTY_MESSAGE("[ERROR] 값에 빈 값이 들어올 수 없습니다."),
    SPACE_MESSAGE("[ERROR] 값에 공백만 들어올 수 없습니다."),
    NUMERIC_FORMAT_MESSAGE("[ERROR] 숫자만 입력할 수 있습니다."),
    NUMBER_RANGE_MESSAGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    SPLIT_MESSAGE(","),
    LOTTO_MIN_NUMBER(1),
    LOTTO_MAX_NUMBER(45);

    private String message;
    private int number;

    CommonErrorConstant(final String message) {
        this.message = message;
    }

    CommonErrorConstant(final int number) {
        this.number = number;
    }

    public String getMessage() {
        return message;
    }
    public int getNumber() {
        return number;
    }

}
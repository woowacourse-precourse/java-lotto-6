package lotto.constants;

public enum ErrorType {
    CONTAIN_DUPLICATED_NUMBER("[ERROR] 중복된 숫자가 존재합니다."),

    LOTTO_NUMBERS_SIZE_IS_NOT_RIGHT("[ERROR] 로또는 6자만 가능합니다."),

    NUMBER_OVER_MAX_OR_MIN_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),

    CAN_NOT_CONVERT_INTEGER("[ERROR] INTEGER로 변환할 수 없습니다."),

    CAN_NOT_SATISFY_INTEGER_CONDITION("[ERROR] 1000원 단위로 입력해야 합니다.");

    private final String errorMessage;

    ErrorType(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}

package lotto.validator.constants;

public enum ErrorType {

    CAN_NOT_CONVERT_INTEGER("[ERROR] INTEGER로 변환할 수 없습니다."),
    CAN_NOT_SATISFY_INTEGER_CONDITION("[ERROR] 1000원 단위로 입력해야 합니다."),
    NUMBER_OVER_MAX_OR_MIN_RANGE("[ERROR] 당첨 번호는 0보다 크고 45보다 작아야 합니다.");

    private final String errorMessage;

    ErrorType(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}

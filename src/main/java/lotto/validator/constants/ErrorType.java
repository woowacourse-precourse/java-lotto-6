package lotto.validator.constants;

public enum ErrorType {

    CAN_NOT_CONVERT_INTEGER_MESSAGE("[ERROR] INTEGER로 변환할 수 없습니다."),
    CAN_NOT_SATISFY_INTEGER_CONDITION("[ERROR] 1000원 단위로 입력해야 합니다.");

    private final String errorMessage;

    ErrorType(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return errorMessage;
    }
}

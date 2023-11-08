package lotto.constant;

public enum ExceptionMessage {
    CAN_NOT_DIVIDE("나누어 떨어지지 않습니다."),
    LESS_THAN_PRICE("금액이 부족합니다."),
    UNVALID_LENGTH("올바른 길이가 아닙니다."),
    IS_DUPLICATED("중복된 숫자가 있습니다."),
    OUT_OF_RANGE("1부터 45 사이의 값만 입력할 수 있습니다."),
    HAS_BLANK("공백은 입력할 수 없습니다."),
    WRONG_TYPE("유효한 숫자가 아닙니다. 양의 정수를 입력해주세요."),
    IS_NEGATIVE("음수는 입력할 수 없습니다.");

    private final String message;

    private ExceptionMessage(String message) {
        String errorTag = "[ERROR] ";
        this.message = errorTag + message;
    }

    public String getMessage() {
        return message;
    }
}

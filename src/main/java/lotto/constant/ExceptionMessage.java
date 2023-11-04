package lotto.constant;

public enum ExceptionMessage {
    CAN_NOT_DIVIDE("나누어 떨어지지 않습니다."),
    LESS_THAN_PRICE("금액이 부족합니다."),
    NEGATIVE_NUMBER("금액은 양수여야 합니다."),
    UNVALID_LENGTH("올바른 길이가 아닙니다."),
    IS_DUPLICATED("중복된 숫자가 있습니다.");

    private final String message;

    private ExceptionMessage(String message) {
        String errorTag = "[ERROR] ";
        this.message = errorTag + message;
    }

    public String getMessage() {
        return message;
    }
}

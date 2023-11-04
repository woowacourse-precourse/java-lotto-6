package lotto.constant;

public enum ExceptionMessage {

    INVALID_PAYMENT_UNIT("1000원 단위로 입력해 주십시오."),
    INCORRECT_DELIMITER("숫자를 쉼표로 구분하여 입력하여 주십시오."),
    INVALID_INPUT_NUMBER("6개의 숫자를 입력하여 주십시오."),
    DUPLICATE_NUMBER("중복되지 않는 6개의 숫자를 입력하여 주십시오."),
    INCORRECT_RANGE("1~45 사이의 숫자만 입력할 수 있습니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}

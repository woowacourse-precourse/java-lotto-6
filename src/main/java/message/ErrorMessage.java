package message;

public enum ErrorMessage {

    INVALID_NUMBER_FORMAT("입력은 숫자 형식 이어야 합니다."),
    INVALID_PRICE_VALUE("금액은 1000원 단위로 입력 되어야 합니다."),
    NEGATIVE_PRICE_VALUE("금액은 0 이상의 정수 이어야 합니다."),
    INVALID_INPUT_FORMAT("숫자와 쉼표(,)만 입력 되어야 합니다."),
    INVALID_NUMBER_RANGE("1 이상 45 이하의 수 만 입력 되어야 합니다."),
    INVALID_NUMBER_COUNT("%s 개의 수가 입력 되어야 합니다."),
    DUPLICATE_NUMBER_EXIST("중복된 숫자가 존재 하지 않아야 합니다.");

    private static final String errorPrefix = "[ERROR] ";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public void print() {
        System.out.println(errorPrefix + message);
    }

    public void print(String prefix) {
        System.out.printf(errorPrefix + message, prefix);
    }
}

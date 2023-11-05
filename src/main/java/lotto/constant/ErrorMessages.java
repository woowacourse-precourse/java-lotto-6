package lotto.constant;

public enum ErrorMessages {
    PREFIX("[ERROR] "),
    SUFFIX(" 다시 입력해 주세요"),
    INVALID_COUNT("입력하신 번호의 개수가 잘못되었습니다."),
    DUPLICATE_NUMBER("중복된 번호가 있습니다."),
    NEGATIVE_AMOUNT("음수는 입력이 불가능합니다."),
    INVALID_RANGE("입력 가능한 번호의 범위는 %d부터 %d까지 입니다."),
    INVALID_TYPE("번호는 숫자만 입력 가능합니다."),
    INVALID_AMOUNT("입력하신 금액으로 나누어 떨어지지 않습니다.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public String format(Object... args) {
        return String.format(message, args);
    }
}

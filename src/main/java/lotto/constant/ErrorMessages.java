package lotto.constant;

public enum ErrorMessages {
    PREFIX("[ERROR]"),
    SUFFIX(" 다시 입력해 주세요"),
    INVALID_COUNT("입력하신 번호의 개수가 잘못되었습니다."),
    DUPLICATE_NUMBER("중복된 번호가 있습니다."),
    INVALID_RANGE("입력 가능한 번호의 범위는 %s부터 %s까지 입니다."),
    INVALID_TYPE("번호는 숫자만 입력 가능합니다.")
    ;

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public String format(String... args) {
        return String.format(message, (Object[]) args);
    }
}
